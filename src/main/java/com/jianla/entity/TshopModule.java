package com.jianla.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 模块组件
 * @author : zwj
 * @data : 2017/4/25
 */
@Entity
@Table(name="tshop_module")
public class TshopModule implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="module_id",nullable = false,unique = true)
    private Long moduleId;

    @Column(name="max_append")
    private Integer maxAppend;//最大添加个数

    @Column(name="name")
    private String name;//模块名称

    @Column(name="icon")
    private String icon;//模块图标

    @Column(name="support_width")
    private String supportWidth;//支持宽度 "b950-b190-b750";

    @Column(name="enabled")
    private Boolean enabled;//是否可用

    @Column(name = "tips")
    private String tips;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getMaxAppend() {
        return maxAppend;
    }

    public void setMaxAppend(Integer maxAppend) {
        this.maxAppend = maxAppend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getSupportWidth() {
        return supportWidth;
    }

    public void setSupportWidth(String supportWidth) {
        this.supportWidth = supportWidth;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
