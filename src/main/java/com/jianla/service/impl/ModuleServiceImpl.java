package com.jianla.service.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.TshopModule;
import com.jianla.model.ModuleModel;
import com.jianla.service.ModuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/5/1
 */
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private BaseDaoI<TshopModule> moduleDao;

    @Override
    public List<ModuleModel> findEnabledModules(Integer width) {
        String hql = "from TshopModule t where t.enabled = true";
        List<TshopModule> tshopModules;
        if(width!=null){
            hql += " and t.supportWidth like ?";
            tshopModules = moduleDao.find(hql,new Object[]{"%"+width+"%"});
        }else{
            tshopModules = moduleDao.find(hql);
        }
        List<ModuleModel> result = new ArrayList<>();
        for (TshopModule tshopModule : tshopModules) {
            ModuleModel moduleModel = new ModuleModel();
            BeanUtils.copyProperties(tshopModule, moduleModel);
            result.add(moduleModel);
        }
        return result;
    }

}
