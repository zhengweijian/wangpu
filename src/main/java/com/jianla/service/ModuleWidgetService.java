package com.jianla.service;

import com.jianla.model.LayoutLocation;
import com.jianla.model.ModuleWidgetModel;

import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/27
 */
public interface ModuleWidgetService {

    /**
     * 增加模块控件
     * @return module widget id
     */
    Long addModuleWidget(Long pageId,Long moduleCompId,LayoutLocation layout);

    /**
     * 移动模块控件
     */
    void moveModuleWidget(Long pageId, Long moduleWidgetId, LayoutLocation from, LayoutLocation to);

    /**
     * 删除模块控件 ,LayoutLocation from
     */
    void delModuleWidget(Long pageId,Long moduleWidgetId);

    /**
     * 找到模块控件
     * @param layoutWidgetId
     * @param slide main或sub
     * @return 排序的模块
     */
    List<ModuleWidgetModel> findByLayoutAndSlide(Long layoutWidgetId,String slide);
}
