package com.jianla.service.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.TshopLayoutWidget;
import com.jianla.entity.TshopModule;
import com.jianla.entity.TshopModuleWidget;
import com.jianla.entity.TshopPage;
import com.jianla.model.LayoutLocation;
import com.jianla.model.ModuleWidgetModel;
import com.jianla.service.ModuleWidgetService;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/5/1
 */
@Service
@Transactional
public class ModuleWidgetServiceImpl implements ModuleWidgetService {

    @Autowired
    private BaseDaoI<TshopPage> pageDao;

    @Autowired
    private BaseDaoI<TshopModule> moduleDao;

    @Autowired
    private BaseDaoI<TshopModuleWidget> moduleWidgetDao;

    @Autowired
    private BaseDaoI<TshopLayoutWidget> layoutWidgetDao;

    @Override
    public Long addModuleWidget(Long pageId, Long moduleCompId, LayoutLocation layoutLocation) {
        TshopPage tshopPage = pageDao.get(TshopPage.class, pageId);
        if (tshopPage == null) {
            throw new RuntimeException("找不到页面id：" + pageId);
        }

        TshopModule tshopModule = moduleDao.get(TshopModule.class, moduleCompId);
        if(tshopModule==null){
            throw new RuntimeException("找不到模块id：" + moduleCompId);
        }
        TshopLayoutWidget tshopLayoutWidget = layoutWidgetDao.get(TshopLayoutWidget.class, layoutLocation.getLayoutWidgetId());
        if (tshopLayoutWidget == null) {
            throw new RuntimeException("找不到布局");
        }
        if(!tshopLayoutWidget.getPageId().equals(pageId)){
            throw new RuntimeException("数据错乱");
        }
        String baseCountHql = "select count(*) from TshopModuleWidget m,TshopLayoutWidget l where m.layoutWidgetId = l.layoutWidgetId";
        String pageModuleCountHql = baseCountHql+" and l.pageId = ?";
        int pageModuleCount = moduleWidgetDao.countHqlResult(pageModuleCountHql, Arrays.asList((Object) pageId));
        if(pageModuleCount>= tshopLayoutWidget.getMaxModule()){
            throw new RuntimeException("该布局最多模块个数："+tshopPage.getMaxModule());
        }
        String moduleNumLimitHql = baseCountHql +  " and l.pageId = ? and m.moduleId = ?";
        int moduleCount = moduleWidgetDao.countHqlResult(moduleNumLimitHql, Arrays.asList(pageId, (Object) moduleCompId));
        if(moduleCount>=tshopModule.getMaxAppend()){
            throw new RuntimeException("超出模块个数限制："+tshopModule.getName()+"页面最多个数"+tshopModule.getMaxAppend());
        }

        TshopModuleWidget tshopModuleWidget = new TshopModuleWidget();
        tshopModuleWidget.setModuleId(tshopModule.getModuleId());
        tshopModuleWidget.setTitle(tshopModule.getTips());
        //新增的都可更改，copy的数据可以在数据库设置
        tshopModuleWidget.setIsdel(true);
        tshopModuleWidget.setIsedit(true);
        tshopModuleWidget.setIsmove(true);
        tshopModuleWidget.setIsadd(true);
        //模块位置信息
        tshopModuleWidget.setLayoutWidgetId(layoutLocation.getLayoutWidgetId());
        tshopModuleWidget.setSlide(layoutLocation.getSlide());
        Integer displayOrder = layoutLocation.getIndex() + 1;//插入order位置  1-n（index从0开始）
        tshopModuleWidget.setDisplayOrder(displayOrder);

        //set lock
        this.setUpdateLock(layoutLocation.getLayoutWidgetId(), layoutLocation.getSlide());

        String orderHql = "update TshopModuleWidget t set t.displayOrder = t.displayOrder+1 where t.layoutWidgetId=? and t.slide=? and t.displayOrder >= ?";
        moduleWidgetDao.executeHql(orderHql, new Object[]{layoutLocation.getLayoutWidgetId(), layoutLocation.getSlide(),displayOrder});

        moduleWidgetDao.save(tshopModuleWidget);
        return tshopModuleWidget.getModuleWidgetId();
    }

    /**
     * 上锁避免幻读
     * @param layoutWidgetId
     * @param slide
     */
    private void setUpdateLock(Long layoutWidgetId,String slide){
        String hql = "from TshopModuleWidget t where t.layoutWidgetId = ? and t.slide = ?";
        Query query = moduleWidgetDao.getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter(0, layoutWidgetId);
        query.setParameter(1, slide);
        query.setLockOptions(LockOptions.UPGRADE);
        query.list();
    }

    @Override
    public void moveModuleWidget(Long pageId, Long moduleWidgetId, LayoutLocation fromLoc, LayoutLocation toLoc) {
        TshopModuleWidget moveModule = moduleWidgetDao.get(TshopModuleWidget.class, moduleWidgetId);
        if(moveModule==null){
            throw new RuntimeException("找不到移动对象");
        }

        //src使用了module widget id的数据
        TshopLayoutWidget srcLayout = layoutWidgetDao.get(TshopLayoutWidget.class, fromLoc.getLayoutWidgetId());
        TshopLayoutWidget descLayout = layoutWidgetDao.get(TshopLayoutWidget.class, toLoc.getLayoutWidgetId());

        if (srcLayout==null || descLayout==null) {
            throw new RuntimeException("找不到目标布局");
        }
        if(!srcLayout.getPageId().equals(pageId) || !descLayout.getPageId().equals(pageId) || !moveModule.getLayoutWidgetId().equals(srcLayout.getLayoutWidgetId())){
            throw new RuntimeException("数据错乱，请刷新页面");
        }

        //set lock
        this.setUpdateLock(moveModule.getLayoutWidgetId(), moveModule.getSlide());

        boolean sameRegion = moveModule.getLayoutWidgetId().equals(descLayout.getLayoutCompId()) && moveModule.getSlide().equals(toLoc.getSlide());
        if(!sameRegion){
            this.setUpdateLock(descLayout.getLayoutWidgetId(),toLoc.getSlide());
        }

        //fromLoc remove
        String fromHql = "update TshopModuleWidget t set t.displayOrder = t.displayOrder-1 where t.layoutWidgetId=? and t.slide=? and t.displayOrder >?";
        moduleWidgetDao.executeHql(fromHql, new Object[]{moveModule.getLayoutWidgetId(), moveModule.getSlide(), moveModule.getDisplayOrder()});

        //toLoc add
        Integer descDisplayOrder = toLoc.getIndex() + 1;
        String descHql = "update TshopModuleWidget t set t.displayOrder = t.displayOrder+1 where t.layoutWidgetId=? and t.slide=? and displayOrder>=?";
        moduleWidgetDao.executeHql(descHql, new Object[]{descLayout.getLayoutWidgetId(), toLoc.getSlide(), descDisplayOrder});

        //module move
        moveModule.setLayoutWidgetId(descLayout.getLayoutWidgetId());
        moveModule.setSlide(toLoc.getSlide());
        moveModule.setDisplayOrder(descDisplayOrder);
        moduleWidgetDao.update(moveModule);
    }

    @Override
    public void delModuleWidget(Long pageId, Long moduleWidgetId) {
        TshopModuleWidget delModule = moduleWidgetDao.get(TshopModuleWidget.class, moduleWidgetId);
        if(delModule==null){
            throw new RuntimeException("找不到删除对象");
        }
        TshopLayoutWidget layoutWidget = layoutWidgetDao.get(TshopLayoutWidget.class, delModule.getLayoutWidgetId());
        if (!layoutWidget.getPageId().equals(pageId) ) {
            throw new RuntimeException("所属页面不正确");
        }

        this.setUpdateLock(layoutWidget.getLayoutWidgetId(), delModule.getSlide());
        String fromHql = "update TshopModuleWidget t set t.displayOrder = t.displayOrder-1 where t.layoutWidgetId=? and t.slide=? and t.displayOrder >?";
        moduleWidgetDao.executeHql(fromHql, new Object[]{delModule.getLayoutWidgetId(), delModule.getSlide(), delModule.getDisplayOrder()});

        moduleWidgetDao.delete(delModule);
    }

    @Override
    public List<ModuleWidgetModel> findByLayoutAndSlide(Long layoutWidgetId, String slide) {
        String hql = "from TshopModuleWidget t where t.layoutWidgetId = ? and t.slide = ? order by displayOrder asc";
        List<TshopModuleWidget> tshopModuleWidgets = moduleWidgetDao.find(hql, new Object[]{layoutWidgetId, slide});
        List<ModuleWidgetModel> result = new ArrayList<>();
        for (TshopModuleWidget tshopModuleWidget : tshopModuleWidgets) {
            result.add(trans2Model(tshopModuleWidget));
        }
        return result;
    }

    private ModuleWidgetModel trans2Model(TshopModuleWidget entity){
        ModuleWidgetModel moduleWidgetModel = new ModuleWidgetModel();
        BeanUtils.copyProperties(entity, moduleWidgetModel);
        TshopModule tshopModule = moduleDao.get(TshopModule.class, moduleWidgetModel.getModuleId());
        moduleWidgetModel.setContext(tshopModule.getSupportWidth());
        return moduleWidgetModel;
    }
}
