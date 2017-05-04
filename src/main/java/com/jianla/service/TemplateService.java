package com.jianla.service;

import com.jianla.model.ShopTemplateModel;

import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/21
 */
public interface TemplateService {

    /**
     * 找到可用的模板，目前只有官方的模板
     * @param orgId
     * @return
     */
    List<ShopTemplateModel> findMyTemp(Long orgId);

    /**
     * 找到所有模板
     * @return
     */
    List<ShopTemplateModel> findAll();

    ShopTemplateModel getById(Long id);

    Long add(ShopTemplateModel templateModel);

    void update(ShopTemplateModel templateModel);

    /**
     * 对模板初始化站点
     * @param skinId
     * @return 模板绑定的站点ID
     */
    Long initSite(Long skinId);
}
