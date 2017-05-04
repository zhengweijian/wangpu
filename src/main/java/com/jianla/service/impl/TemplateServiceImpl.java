package com.jianla.service.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.*;
import com.jianla.model.ShopTemplateModel;
import com.jianla.service.SiteInstanceService;
import com.jianla.service.TempSkinService;
import com.jianla.service.TemplateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/21
 */
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private BaseDaoI<Tshop> shopDao;

    @Autowired
    private BaseDaoI<TshopTemplate> templateDao;

    @Autowired
    private BaseDaoI<TshopTempSkin> tempSkinDao;

    @Autowired
    private TempSkinService tempSkinService;

    @Autowired
    private BaseDaoI<TshopTempSite> tempSiteDao;

    @Autowired
    private BaseDaoI<TshopSiteInstance> siteInstanceDao;

    @Autowired
    private SiteInstanceService siteInstanceService;

    @Override
    public List<ShopTemplateModel> findMyTemp(Long orgId) {
        Tshop tshop = shopDao.get(Tshop.class, orgId);
        Long currentSiteId = tshop.getCurrentSiteId();
        Long currentTemplateId = null;
        if(currentSiteId!=null){//已开启旺铺
            TshopSiteInstance currentSite = siteInstanceDao.get(TshopSiteInstance.class, currentSiteId);
            currentTemplateId = currentSite.getTemplateId();
        }

        String hql = "from TshopTemplate t where t.type=? and t.status = ?";
        List<TshopTemplate> tshopTemplates = templateDao.find(hql, new Object[]{ShopTemplateModel.TYPE_OFFICIAL, ShopTemplateModel.STATUS_RELEASED});

        List<ShopTemplateModel> result = new ArrayList<>();
        for (TshopTemplate tshopTemplate : tshopTemplates) {
            ShopTemplateModel model = change2Model(tshopTemplate);
            boolean inUse = false;
            if (model.getId().equals(currentTemplateId)) {
                model.setInUse(true);
            }
            model.setInUse(inUse);
            result.add(model);
        }

        return result;
    }

    @Override
    public List<ShopTemplateModel> findAll() {
        String hql = "from TshopTemplate t";
        List<TshopTemplate> tshopTemplates = templateDao.find(hql);

        List<ShopTemplateModel> result = new ArrayList<>();
        for (TshopTemplate tshopTemplate : tshopTemplates) {
            ShopTemplateModel model = change2Model(tshopTemplate);
            result.add(model);
        }
        return result;
    }

    @Override
    public ShopTemplateModel getById(Long id) {
        TshopTemplate tshopTemplate = templateDao.get(TshopTemplate.class, id);
        return change2Model(tshopTemplate);
    }

    @Override
    public Long add(ShopTemplateModel templateModel) {
        TshopTemplate template = new TshopTemplate();
        BeanUtils.copyProperties(templateModel,template);
        template.setCreateTime(new Date());
        template.setStatus(ShopTemplateModel.STATUS_INIT);
        templateDao.save(template);
        return template.getId();
    }

    @Override
    public void update(ShopTemplateModel templateModel) {
        TshopTemplate template = templateDao.get(TshopTemplate.class,templateModel.getId());
        BeanUtils.copyProperties(templateModel,template);
        templateDao.update(template);
    }

    @Override
    public Long initSite(Long skinId) {
        TshopTempSkin tshopTempSkin = tempSkinDao.get(TshopTempSkin.class, skinId);
        if(tshopTempSkin==null) {
            throw new RuntimeException("找不到模板配色");
        }
        Long templateId = tshopTempSkin.getTemplateId();
        //find exist ?
        TshopTempSite existTempSite = getTempSiteByTempId(templateId);
        if(existTempSite!=null){
            return existTempSite.getSiteInstanceId();
        }

        //copy 2 template init site
        Long siteId = siteInstanceService.copy2Temp(templateId,tshopTempSkin.getSkinId());
        //add relationship
        TshopTempSite tshopTempSite = new TshopTempSite();
        tshopTempSite.setSiteInstanceId(siteId);
        tshopTempSite.setTemplateId(templateId);

        return (Long) tempSiteDao.save(tshopTempSite);
    }

    private TshopTempSite getTempSiteByTempId(Long templateId){
        String hql = "from TshopTempSite t where t.templateId = ?";
        return tempSiteDao.get(hql, new Object[]{templateId});
    }

    private ShopTemplateModel change2Model(TshopTemplate entity) {
        ShopTemplateModel model = new ShopTemplateModel();
        BeanUtils.copyProperties(entity, model);
        model.setSkinList(tempSkinService.findByTempId(entity.getId()));
        TshopTempSite tempSite = getTempSiteByTempId(entity.getId());
        if(tempSite!=null){
            model.setInitSiteId(tempSite.getSiteInstanceId());
        }
        return model;
    }
}
