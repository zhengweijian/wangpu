package com.jianla.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 模块控件
 * @author : zwj
 * @data : 2017/4/25
 */
@Entity
@Table(name="tshop_module_widget")
public class TshopModuleWidget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="module_widget_id",nullable = false,unique = true)
    private Long moduleWidgetId;//模块控件id

    @Column(name="layout_widget_id")
    private Long layoutWidgetId;//所属布局控件

    @Column(name="slide")
    private String slide;//main or sub

    @Column(name="display_order")
    private Integer displayOrder;

    @Column(name="module_id")
    private Long moduleId;//模块组件id

    @Column(name="title")
    private String title;//标题

    @Column(name="is_del")
    private Boolean isdel;//是否可删除模块

    @Column(name="is_edit")
    private Boolean isedit;//是否可编辑

    @Column(name="is_move")
    private Boolean ismove;//是否可移动模块（自己移动）

    @Column(name="is_add")
    private Boolean isadd;//是否可以移动/增加到后面

    @Column(name="form_json")
    private String formJson;//表单数据


    public Long getModuleWidgetId() {
        return moduleWidgetId;
    }

    public void setModuleWidgetId(Long moduleWidgetId) {
        this.moduleWidgetId = moduleWidgetId;
    }

    public Long getLayoutWidgetId() {
        return layoutWidgetId;
    }

    public void setLayoutWidgetId(Long layoutWidgetId) {
        this.layoutWidgetId = layoutWidgetId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public Boolean getIsmove() {
        return ismove;
    }

    public void setIsmove(Boolean ismove) {
        this.ismove = ismove;
    }

    public String getFormJson() {
        return formJson;
    }

    public void setFormJson(String formJson) {
        this.formJson = formJson;
    }

    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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
