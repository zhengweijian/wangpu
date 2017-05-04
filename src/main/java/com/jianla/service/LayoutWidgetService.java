package com.jianla.service;

import com.jianla.model.LayoutWidgetModel;

import java.util.List;

/**
 * 布局控件服务
 * @author : zwj
 * @data : 2017/4/27
 */
public interface LayoutWidgetService {

    /**
     * 增加布局控件到页面最后（hd和ft只能有一个）
     *
     * @param pageId 所属页面
     * @param layoutCompId 布局组件id
     * @return 布局控件id
     */
    Long addLayoutWidget(Long pageId,Long layoutCompId);

    /**
     *
     * @param pageId 页面id
     * @param layoutWidgetId 布局组件id
     * @param direction 负数向前-1，正数向后+1
     */
    void moveLayout(Long pageId,Long layoutWidgetId,Integer direction);

    /**
     * 改变布局组件（只有 sm 和 ms可以转换）
     * @param pageId 页面id
     * @param layoutWidgetId 布局控件id
     * @param descLayoutCompId 目标布局组件id
     */
    void replaceLayout(Long pageId,Long layoutWidgetId,Long descLayoutCompId);

    /**
     * 删除布局控件（包括数据）
     * @param pageId 页面id
     * @param layoutWidgetId 布局控件id
     */
    void delLayout(Long pageId,Long layoutWidgetId);

    /**
     * 找到布局控件
     * @param pageId
     * @param layoutType
     * @return
     */
    List<LayoutWidgetModel> findByPageIdAndLayoutType(Long pageId, String layoutType);

    LayoutWidgetModel getHeadByPageId(Long pageId);

    LayoutWidgetModel getFootByPageId(Long pageId);

    List<LayoutWidgetModel> findBodyByPageId(Long pageId);

}
