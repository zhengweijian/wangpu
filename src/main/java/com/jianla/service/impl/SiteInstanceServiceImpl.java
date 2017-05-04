package com.jianla.service.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.*;
import com.jianla.model.SiteInstanceModel;
import com.jianla.service.SiteInstanceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/29
 */
@Service
@Transactional
public class SiteInstanceServiceImpl implements SiteInstanceService {

    @Autowired
    private BaseDaoI<TshopSiteInstance> siteInstanceDao;

    @Autowired
    private BaseDaoI<Tshop> shopDao;

    @Autowired
    private BaseDaoI<TshopPage> pageDao;

    @Autowired
    private BaseDaoI<TshopLayoutWidget> layoutWidgetDao;

    @Autowired
    private BaseDaoI<TshopModuleWidget> moduleWidgetDao;

    /**
     * 拷贝一个站点的数据到另一个站点
     * @param siteInstanceId 源站点
     * @param type DEFAULT 0 平台，BUILD 1 机构
     * @param orgId 所属机构（当type=1时不为空）
     * @param templateId 模板id（冗余、无法修改）
     * @param tempSkinId 模板皮肤id
     * @return 拷贝成功后的站点ID
     */
    private Long copy(Long siteInstanceId,Short type,Long orgId,Long templateId,Long tempSkinId) {

        TshopSiteInstance tshopSiteInstance = siteInstanceDao.get(TshopSiteInstance.class, siteInstanceId);
        if(tshopSiteInstance==null){
            throw new RuntimeException("找不到网站实例[ID="+siteInstanceId+"]");
        }
        TshopSiteInstance newSite = new TshopSiteInstance();
        BeanUtils.copyProperties(tshopSiteInstance,newSite);
        if(type.equals(SiteInstanceModel.TYPE_TEMPLATE)){//只拷贝数据重新设置模板
            newSite.setTemplateId(templateId);
            newSite.setTempSkinId(tempSkinId);
        }else if(type.equals(SiteInstanceModel.TYPE_BACKUP)){//拷贝模板
            newSite.setOrgId(orgId);
        }else{
            throw new RuntimeException("不支持的site type "+type);
        }

        Long newSiteId = (Long) siteInstanceDao.save(newSite);

        //拷贝其他数据
        String findPageHql = "from TshopPage t where t.siteInstanceId = ?";
        String findLayoutHql = "from TshopLayoutWidget t where t.pageId = ?";
        String findModuleHql = "from TshopModuleWidget t where t.layoutWidgetId = ?";
        List<TshopPage> tshopPages = pageDao.find(findPageHql, new Object[]{siteInstanceId});
        for (TshopPage oldPage : tshopPages) {//copy page
            TshopPage newPage = new TshopPage();
            BeanUtils.copyProperties(oldPage,newPage);
            newPage.setSiteInstanceId(newSiteId);
            Long pageId = (Long) pageDao.save(newPage);

            List<TshopLayoutWidget> tshopLayoutWidgets = layoutWidgetDao.find(findLayoutHql, new Object[]{oldPage.getId()});
            for (TshopLayoutWidget oldLayout : tshopLayoutWidgets) {//copy layout
                TshopLayoutWidget newLayout = new TshopLayoutWidget();
                BeanUtils.copyProperties(oldLayout,newLayout);
                newLayout.setPageId(pageId);
                Long layoutId = (Long) layoutWidgetDao.save(newLayout);

                List<TshopModuleWidget> tshopModuleWidgets = moduleWidgetDao.find(findModuleHql, new Object[]{oldLayout.getLayoutWidgetId()});
                for (TshopModuleWidget oldModule : tshopModuleWidgets) {
                    TshopModuleWidget newModule = new TshopModuleWidget();
                    BeanUtils.copyProperties(oldModule,newModule);
                    newModule.setLayoutWidgetId(layoutId);
                    moduleWidgetDao.save(newModule);
                }
            }
        }

        return newSiteId;
    }

    @Override
    public Long copy2Temp(Long templateId, Long tempSkinId) {
        return copy(1L, SiteInstanceModel.TYPE_TEMPLATE,null,templateId,tempSkinId);
    }

    @Override
    public Long copy2Org(Long siteInstanceId, Long orgId) {
        return copy(siteInstanceId, SiteInstanceModel.TYPE_BACKUP,orgId,null,null);
    }

    @Override
    public SiteInstanceModel getCurrentSite(Long orgId) {
        Tshop tshop = shopDao.get("from Tshop t where orgId = ?", new Object[]{orgId});
        if(tshop==null)  throw new RuntimeException("找不到店铺ID="+orgId);
        if(tshop.getCurrentSiteId()==null) throw new RuntimeException("没有开启旺铺，shop id = "+tshop.getId());

        TshopSiteInstance tshopSiteInstance = siteInstanceDao.get(TshopSiteInstance.class, tshop.getCurrentSiteId());
        return change2Model(tshopSiteInstance);
    }

    @Override
    public SiteInstanceModel getReleaseSite(Long orgId) {
        Tshop tshop = shopDao.get("from Tshop t where orgId = ?", new Object[]{orgId});
        if(tshop==null)  throw new RuntimeException("找不到店铺ID="+orgId);
        if(tshop.getReleasedSiteId()==null) throw new RuntimeException("没有发布旺铺，shop id = "+tshop.getId());

        TshopSiteInstance tshopSiteInstance = siteInstanceDao.get(TshopSiteInstance.class, tshop.getReleasedSiteId());
        return change2Model(tshopSiteInstance);
    }

    @Override
    public Long releaseSite(Long orgId) {
        Tshop tshop = shopDao.get("from Tshop t where orgId = ?", new Object[]{orgId});
        if(tshop==null)  throw new RuntimeException("找不到店铺ID="+orgId);
        if(tshop.getCurrentSiteId()==null) throw new RuntimeException("没有开启旺铺，shop id = "+tshop.getId());

        if(tshop.getReleasedSiteId()!=null){
            System.out.println("删除旧的发布站点？");
        }

        Long newSiteId = this.copy2Org(tshop.getCurrentSiteId(), orgId);
        tshop.setReleasedSiteId(newSiteId);
        shopDao.update(tshop);
        return newSiteId;
    }


    private SiteInstanceModel change2Model(TshopSiteInstance siteInstance){
        SiteInstanceModel model = new SiteInstanceModel();
        BeanUtils.copyProperties(siteInstance,model);
        return model;
    }
}
