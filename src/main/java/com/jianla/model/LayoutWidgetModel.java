package com.jianla.model;

import java.util.List;

/**
 * header(hd)和footer(ft)不能移动删除
 * bodies(bd)可以移动、删除，
 * @author : zwj
 * @data : 2017/4/20
 */
public class LayoutWidgetModel {

    private Long layoutCompId;//布局组件id

    private Long layoutWidgetId;//布局元件id

    private Long pageId;//页面id

    private String cssName;//类名（组件定的）

    private String mainWidth;

    private String subWidth;

    private Integer maxModule;

    private List<ModuleWidgetModel> main;//主模块 750、950

    private List<ModuleWidgetModel> sub;//辅模块 190

    public Long getLayoutCompId() {
        return layoutCompId;
    }

    public void setLayoutCompId(Long layoutCompId) {
        this.layoutCompId = layoutCompId;
    }

    public Long getLayoutWidgetId() {
        return layoutWidgetId;
    }

    public void setLayoutWidgetId(Long layoutWidgetId) {
        this.layoutWidgetId = layoutWidgetId;
    }

    public String getCssName() {
        return cssName;
    }

    public void setCssName(String cssName) {
        this.cssName = cssName;
    }

    public List<ModuleWidgetModel> getMain() {
        return main;
    }

    public void setMain(List<ModuleWidgetModel> main) {
        this.main = main;
    }

    public List<ModuleWidgetModel> getSub() {
        return sub;
    }

    public void setSub(List<ModuleWidgetModel> sub) {
        this.sub = sub;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getMainWidth() {
        return mainWidth;
    }

    public void setMainWidth(String mainWidth) {
        this.mainWidth = mainWidth;
    }

    public String getSubWidth() {
        return subWidth;
    }

    public void setSubWidth(String subWidth) {
        this.subWidth = subWidth;
    }

    public Integer getMaxModule() {
        return maxModule;
    }

    public void setMaxModule(Integer maxModule) {
        this.maxModule = maxModule;
    }
}
