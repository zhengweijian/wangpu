package com.jianla.service.impl;

import com.jianla.constant.LayoutTypeEnum;
import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.TshopLayoutComp;
import com.jianla.entity.TshopLayoutWidget;
import com.jianla.entity.TshopPage;
import com.jianla.model.LayoutWidgetModel;
import com.jianla.service.LayoutWidgetService;
import com.jianla.service.ModuleWidgetService;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/27
 */
@Service
@Transactional
public class LayoutWidgetServiceImpl implements LayoutWidgetService {

    @Autowired
    private BaseDaoI<TshopPage> pageDao;

    @Autowired
    private BaseDaoI<TshopLayoutComp> layoutCompDao;

    @Autowired
    private BaseDaoI<TshopLayoutWidget> layoutWidgetDao;

    @Autowired
    private ModuleWidgetService moduleWidgetService;

    @Override
    public Long addLayoutWidget(Long pageId, Long layoutCompId) {
        TshopPage tshopPage = pageDao.get(TshopPage.class, pageId);
        if(tshopPage==null){
            throw new RuntimeException("页面不存在：id=" + pageId);
        }

        TshopLayoutComp tshopLayoutComp = layoutCompDao.get(TshopLayoutComp.class, layoutCompId);
        if (tshopLayoutComp == null){
            throw new RuntimeException("布局组件不存在：id=" + layoutCompId);
        }

        String layoutType = tshopLayoutComp.getLayoutType();
        //set lock
        String lockHql = "from TshopLayoutWidget t where t.pageId = ? and t.layoutType = ?";
        Query query = layoutWidgetDao.getSessionFactory().getCurrentSession().createQuery(lockHql);
        query.setLockOptions(LockOptions.UPGRADE);
        query.setParameter(0,pageId);
        query.setParameter(1,layoutType);
        query.list();

        String hql = "select count(*) from TshopLayoutWidget where pageId = ? and layoutType = ?";
        Long count;
        int maxModule = 1;
        if (layoutType.equals(LayoutTypeEnum.HEAD.name())) {
            count = layoutWidgetDao.count(hql, new Object[]{pageId, layoutType});
            if (count >= 1) {
                throw new RuntimeException("页头最多添加1个");
            }
        } else if (layoutType.equals(LayoutTypeEnum.BODY.name())) {
            count = layoutWidgetDao.count(hql, new Object[]{pageId, layoutType});
            maxModule = 40;
            if (count >= tshopPage.getMaxLayout()) {//个数 limit <=5
                throw new RuntimeException("页中最多添加5个");
            }
        } else if (layoutType.equals(LayoutTypeEnum.FOOT.name())) {
            count = layoutWidgetDao.count(hql, new Object[]{pageId, layoutType});
            if (count >= 1) {
                throw new RuntimeException("页尾最多添加一个");
            }
        } else {
            throw new RuntimeException("不支持的layout类型");
        }

        TshopLayoutWidget tshopLayoutWidget = new TshopLayoutWidget();
        tshopLayoutWidget.setLayoutCompId(layoutCompId);
        tshopLayoutWidget.setPageId(pageId);
        tshopLayoutWidget.setLayoutType(tshopLayoutComp.getLayoutType());
        tshopLayoutWidget.setMaxModule(maxModule);
        tshopLayoutWidget.setDisplayOrder(count.intValue() + 1);

        layoutWidgetDao.save(tshopLayoutWidget);

        return tshopLayoutWidget.getLayoutWidgetId();
    }

    @Override
    public void moveLayout(Long pageId, Long layoutWidgetId, Integer direction) {
        direction = direction < 0 ? -1 : 1;
        Session currentSession = layoutWidgetDao.getSessionFactory().getCurrentSession();
        TshopLayoutWidget tshopLayoutWidget = currentSession.get(TshopLayoutWidget.class, layoutWidgetId, LockOptions.UPGRADE);
        if (!tshopLayoutWidget.getLayoutType().equals(LayoutTypeEnum.BODY.name())) {
            throw new RuntimeException("head和foot无法移动");
        }

        String hql = "from TshopLayoutWidget where pageId = ? and layoutType = ? and displayOrder = ?";
        Query query = currentSession.createQuery(hql);
        query.setLockOptions(LockOptions.UPGRADE);
        query.setParameter(0, pageId);
        query.setParameter(1, LayoutTypeEnum.BODY.name());
        query.setParameter(2, tshopLayoutWidget.getDisplayOrder() + direction);
        List list = query.list();

        if (list != null && list.size() > 0) {
            TshopLayoutWidget tmp = (TshopLayoutWidget) list.get(0);
            Integer tmpOrder = tmp.getDisplayOrder();
            tmp.setDisplayOrder(tshopLayoutWidget.getDisplayOrder());
            tshopLayoutWidget.setDisplayOrder(tmpOrder);
            currentSession.update(tmp);
            currentSession.update(tshopLayoutWidget);
        }
    }

    @Override
    public void replaceLayout(Long pageId, Long layoutWidgetId, Long descLayoutCompId) {
        TshopLayoutWidget tshopLayoutWidget = layoutWidgetDao.get(TshopLayoutWidget.class, layoutWidgetId);
        if (tshopLayoutWidget == null || !tshopLayoutWidget.getPageId().equals(pageId)) {
            throw new RuntimeException("控件不存在");
        }

        TshopLayoutComp srcLayoutComp = layoutCompDao.get(TshopLayoutComp.class, tshopLayoutWidget.getLayoutCompId());
        TshopLayoutComp descLayoutComp = layoutCompDao.get(TshopLayoutComp.class, descLayoutCompId);
        if (srcLayoutComp.getTransGroup().equals(descLayoutComp.getTransGroup())) {
            tshopLayoutWidget.setLayoutCompId(descLayoutCompId);
            layoutWidgetDao.update(tshopLayoutWidget);
        }
    }

    @Override
    public void delLayout(Long pageId, Long layoutWidgetId) {
        TshopLayoutWidget tshopLayoutWidget = layoutWidgetDao.get(TshopLayoutWidget.class, layoutWidgetId);
        if (tshopLayoutWidget == null || !tshopLayoutWidget.getPageId().equals(pageId)) {
            throw new RuntimeException("控件不存在");
        }
        if(!tshopLayoutWidget.getLayoutType().equals(LayoutTypeEnum.BODY.name())){
            throw new RuntimeException("只有body布局才能删除");
        }
        //set lock
        String lockHql = "from TshopLayoutWidget t where t.pageId = ? and t.layoutType = ?";
        Query query = layoutWidgetDao.getSessionFactory().getCurrentSession().createQuery(lockHql);
        query.setLockOptions(LockOptions.UPGRADE);
        query.setParameter(0,pageId);
        query.setParameter(1,tshopLayoutWidget.getLayoutType());
        query.list();

        //删除模块
        String hql = "delete from TshopModuleWidget t where t.layoutWidgetId = ?";
        layoutWidgetDao.executeHql(hql, new Object[]{tshopLayoutWidget.getLayoutWidgetId()});

        //删除布局
        layoutWidgetDao.delete(tshopLayoutWidget);

        String orderHql = "update TshopLayoutWidget set displayOrder = displayOrder-1 where pageId = ? and displayOrder > ?";
        layoutWidgetDao.executeHql(orderHql,new Object[]{pageId,tshopLayoutWidget.getDisplayOrder()});
    }

    @Override
    public List<LayoutWidgetModel> findByPageIdAndLayoutType(Long pageId, String layoutType) {
        LayoutTypeEnum layoutTypeEnum = LayoutTypeEnum.valueOf(layoutType);
        String hql = "from TshopLayoutWidget t where t.pageId = ? and t.layoutType = ? order by t.displayOrder asc";
        List<TshopLayoutWidget> tshopLayoutWidgets = layoutWidgetDao.find(hql, new Object[]{pageId, layoutTypeEnum.name()});

        List<LayoutWidgetModel> results = new ArrayList<>();
        for (TshopLayoutWidget tshopLayoutWidget : tshopLayoutWidgets) {
            results.add(trans2Model(tshopLayoutWidget));
        }
        return results;
    }

    @Override
    public LayoutWidgetModel getHeadByPageId(Long pageId) {
        List<LayoutWidgetModel> list = findByPageIdAndLayoutType(pageId, LayoutTypeEnum.HEAD.name());
        if (list != null && list.size() > 0) return list.get(0);
        else{
            TshopLayoutWidget tshopLayoutWidget = new TshopLayoutWidget();
            tshopLayoutWidget.setLayoutCompId(1L);
            tshopLayoutWidget.setPageId(pageId);
            tshopLayoutWidget.setDisplayOrder(0);
            tshopLayoutWidget.setLayoutType("HEAD");
            layoutWidgetDao.save(tshopLayoutWidget);
            return trans2Model(tshopLayoutWidget);
        }
    }

    @Override
    public LayoutWidgetModel getFootByPageId(Long pageId) {
        List<LayoutWidgetModel> list = findByPageIdAndLayoutType(pageId, LayoutTypeEnum.FOOT.name());
        if (list != null && list.size() > 0) return list.get(0);
        else{
            TshopLayoutWidget tshopLayoutWidget = new TshopLayoutWidget();
            tshopLayoutWidget.setLayoutCompId(2L);
            tshopLayoutWidget.setPageId(pageId);
            tshopLayoutWidget.setDisplayOrder(0);
            tshopLayoutWidget.setLayoutType("FOOT");
            layoutWidgetDao.save(tshopLayoutWidget);
            return trans2Model(tshopLayoutWidget);
        }
    }

    @Override
    public List<LayoutWidgetModel> findBodyByPageId(Long pageId){
        return findByPageIdAndLayoutType(pageId, LayoutTypeEnum.BODY.name());
    }

    private LayoutWidgetModel trans2Model(TshopLayoutWidget entity) {
        LayoutWidgetModel model = new LayoutWidgetModel();
        BeanUtils.copyProperties(entity, model);
        //add layout comp
        TshopLayoutComp tshopLayoutComp = layoutCompDao.get(TshopLayoutComp.class, entity.getLayoutCompId());
        model.setCssName(tshopLayoutComp.getCssName());
        model.setMainWidth(tshopLayoutComp.getMainWidth());
        model.setSubWidth(tshopLayoutComp.getSubWidth());
        //add modules main and sub
        model.setMain(moduleWidgetService.findByLayoutAndSlide(entity.getLayoutWidgetId(), "main"));
        model.setSub(moduleWidgetService.findByLayoutAndSlide(entity.getLayoutWidgetId(), "sub"));
        return model;
    }
}
