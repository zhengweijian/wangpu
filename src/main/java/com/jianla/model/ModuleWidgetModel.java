package com.jianla.model;

/**
 * 模块控件模型
 *
 * @author : zwj
 * @data : 2017/4/20
 */
public class ModuleWidgetModel {

    private Long moduleId;//模块id

    private Long moduleWidgetId;//模块控件id

    private String title;//模块控件名称

    //layoutid-slide-order

    //tool bar
    private String context;//组件-可移动到

    private Boolean ismove;//是否可移动

    private Boolean isdel;//是否可删除

    private Boolean isedit;//是否可编辑

    private Boolean isadd;//是否可增加到该模块之后

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getModuleWidgetId() {
        return moduleWidgetId;
    }

    public void setModuleWidgetId(Long moduleWidgetId) {
        this.moduleWidgetId = moduleWidgetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Boolean getIsmove() {
        return ismove;
    }

    public void setIsmove(Boolean ismove) {
        this.ismove = ismove;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public Boolean getIsedit() {
        return isedit;
    }

    public void setIsedit(Boolean isedit) {
        this.isedit = isedit;
    }

    public Boolean getIsadd() {
        return isadd;
    }

    public void setIsadd(Boolean isadd) {
        this.isadd = isadd;
    }
}
