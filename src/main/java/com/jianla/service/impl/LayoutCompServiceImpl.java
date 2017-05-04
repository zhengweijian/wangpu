package com.jianla.service.impl;

import com.jianla.constant.LayoutTypeEnum;
import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.TshopLayoutComp;
import com.jianla.model.LayoutCompModel;
import com.jianla.service.LayoutCompService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/5/2
 */
@Service
@Transactional
public class LayoutCompServiceImpl implements LayoutCompService {

    @Autowired
    private BaseDaoI<TshopLayoutComp> layoutCompDao;

    @Override
    public List<LayoutCompModel> findBodyLayout() {
        String hql = "from TshopLayoutComp t where t.layoutType = ?";
        List<TshopLayoutComp> tshopLayoutComps = layoutCompDao.find(hql, new Object[]{LayoutTypeEnum.BODY.name()});
        List<LayoutCompModel> result = new ArrayList<>();
        for (TshopLayoutComp tshopLayoutComp : tshopLayoutComps) {
            LayoutCompModel model = new LayoutCompModel();
            BeanUtils.copyProperties(tshopLayoutComp, model);
            result.add(model);
        }
        return result;
    }
}
