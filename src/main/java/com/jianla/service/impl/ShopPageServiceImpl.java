package com.jianla.service.impl;

import com.jianla.constant.ShopPageTypeEnum;
import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.TshopPage;
import com.jianla.entity.TshopSiteInstance;
import com.jianla.model.ShopPageModel;
import com.jianla.service.ShopPageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/21
 */
@Service
@Transactional
public class ShopPageServiceImpl implements ShopPageService {

    @Autowired
    private BaseDaoI<TshopSiteInstance> siteInstanceDao;

    @Autowired
    private BaseDaoI<TshopPage> shopPageDao;

    @Override
    public ShopPageModel getById(Long pageId) {
        TshopPage tshopPage = shopPageDao.get(TshopPage.class, pageId);
        return change2Model(tshopPage);
    }

    @Override
    public ShopPageModel getIndexPageBySite(Long siteId) {
        TshopSiteInstance tshopSiteInstance = siteInstanceDao.get(TshopSiteInstance.class, siteId);

        List<ShopPageModel> indexPage = this.findBySiteAndType(tshopSiteInstance.getId(), ShopPageTypeEnum.INDEX);
        if(indexPage==null || indexPage.size()==0) throw new RuntimeException("网站["+tshopSiteInstance.getId()+"]首页不存在");

        return indexPage.get(0);
    }

    @Override
    public List<ShopPageModel> findBySite(Long siteId){
        String hql = "from TshopPage t where t.siteInstanceId = ?";
        List<TshopPage> tshopPages = shopPageDao.find(hql, new Object[]{siteId});
        List<ShopPageModel> results = new ArrayList<>();
        for (TshopPage tshopPage : tshopPages) {
            ShopPageModel model = new ShopPageModel();
            BeanUtils.copyProperties(tshopPage,model);
            results.add(model);
        }
        return results;
    }

    @Override
    public List<ShopPageModel> findBySiteAndType(Long siteId, ShopPageTypeEnum index) {
        String hql = "from TshopPage t where t.siteInstanceId = ? and pageType = ?";
        List<TshopPage> tshopPages = shopPageDao.find(hql, new Object[]{siteId, index.getValue()});
        List<ShopPageModel> results = new ArrayList<>();
        for (TshopPage tshopPage : tshopPages) {
            ShopPageModel model = new ShopPageModel();
            BeanUtils.copyProperties(tshopPage,model);
            results.add(model);
        }
        return results;
    }

    private ShopPageModel change2Model(TshopPage tshopPage){
        ShopPageModel model = new ShopPageModel();
        BeanUtils.copyProperties(tshopPage,model);
        return model;
    }
}
