package com.jianla.service;

import com.jianla.model.ShopTempSkinModel;

import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/21
 */
public interface TempSkinService {

    Long add(ShopTempSkinModel model);

    void update(ShopTempSkinModel model);

    void delete(Long id);

    ShopTempSkinModel getById(Long skinId);

    List<ShopTempSkinModel> findByTempId(Long templateId);
}
