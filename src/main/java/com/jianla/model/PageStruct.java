package com.jianla.model;

import java.util.List;

/**
 * 页面结构
 *
 * @author : zwj
 * @data : 2017/4/20
 */
public class PageStruct {

    private List<LayoutWidgetModel> hd;//header

    private List<LayoutWidgetModel> bd;//bodies

    private List<LayoutWidgetModel> ft;//footer

    private Integer maxLayout;//最多bd个数，布局不超过  5

    private Integer maxModule;//最大模块

    public List<LayoutWidgetModel> getHd() {
        return hd;
    }

    public void setHd(List<LayoutWidgetModel> hd) {
        this.hd = hd;
    }

    public List<LayoutWidgetModel> getBd() {
        return bd;
    }

    public void setBd(List<LayoutWidgetModel> bd) {
        this.bd = bd;
    }

    public List<LayoutWidgetModel> getFt() {
        return ft;
    }

    public void setFt(List<LayoutWidgetModel> ft) {
        this.ft = ft;
    }

    public Integer getMaxLayout() {
        return maxLayout;
    }

    public void setMaxLayout(Integer maxLayout) {
        this.maxLayout = maxLayout;
    }

    public Integer getMaxModule() {
        return maxModule;
    }

    public void setMaxModule(Integer maxModule) {
        this.maxModule = maxModule;
    }
}
