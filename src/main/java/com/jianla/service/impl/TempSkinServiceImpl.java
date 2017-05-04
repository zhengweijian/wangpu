package com.jianla.service.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.TshopTempSkin;
import com.jianla.model.ShopTempSkinModel;
import com.jianla.service.TempSkinService;
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
public class TempSkinServiceImpl implements TempSkinService {

    @Autowired
    private BaseDaoI<TshopTempSkin> tempSkinDao;

    @Override
    public Long add(ShopTempSkinModel model) {
        TshopTempSkin tshopTempSkin = new TshopTempSkin();
        BeanUtils.copyProperties(model,tshopTempSkin);
        tshopTempSkin.setDeleted(false);
        tempSkinDao.save(tshopTempSkin);
        return tshopTempSkin.getSkinId();
    }

    @Override
    public void update(ShopTempSkinModel model) {
        TshopTempSkin tshopTempSkin = tempSkinDao.get(TshopTempSkin.class,model.getSkinId());
        BeanUtils.copyProperties(model,tshopTempSkin);
        tempSkinDao.update(tshopTempSkin);
    }

    @Override
    public void delete(Long skinId) {
        TshopTempSkin tshopTempSkin = tempSkinDao.get(TshopTempSkin.class, skinId);
        tshopTempSkin.setDeleted(true);
        tempSkinDao.update(tshopTempSkin);
    }

    @Override
    public ShopTempSkinModel getById(Long skinId) {
        TshopTempSkin tshopTempSkin = tempSkinDao.get(TshopTempSkin.class, skinId);
        return change2Model(tshopTempSkin);
    }

    @Override
    public List<ShopTempSkinModel> findByTempId(Long templateId) {
        String hql = "from TshopTempSkin t where t.templateId = ? and t.deleted = false";
        List<TshopTempSkin> tshopTempSkins = tempSkinDao.find(hql, new Object[]{templateId});

        List<ShopTempSkinModel> result = new ArrayList<>();
        for (TshopTempSkin tshopTempSkin : tshopTempSkins) {
            result.add(change2Model(tshopTempSkin));
        }
        return result;
    }

    private ShopTempSkinModel change2Model(TshopTempSkin tshopTempSkin){
        ShopTempSkinModel model = new ShopTempSkinModel();
        BeanUtils.copyProperties(tshopTempSkin,model);
        return model;
    }

}
