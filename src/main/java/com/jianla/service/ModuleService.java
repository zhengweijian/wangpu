package com.jianla.service;

import com.jianla.model.ModuleModel;

import java.util.List;

/**
 * 模块组件
 * @author : zwj
 * @data : 2017/5/1
 */
public interface ModuleService {

    List<ModuleModel> findEnabledModules(Integer width);
}
