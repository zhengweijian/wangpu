package com.jianla.service;

import com.jianla.constant.ShopPageTypeEnum;
import com.jianla.model.ShopPageModel;

import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/20
 */
public interface ShopPageService {

    ShopPageModel getById(Long pageId);

    ShopPageModel getIndexPageBySite(Long siteId);

    List<ShopPageModel> findBySite(Long siteId);

    List<ShopPageModel> findBySiteAndType(Long id, ShopPageTypeEnum index);
}
