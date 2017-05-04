package com.jianla.model;

/**
 * @author : zwj
 * @data : 2017/5/1
 */
public class ModuleModel {

    private Long moduleId;

    private Integer maxAppend;//最大添加个数

    private String name;//模块名称

    private String icon;//模块图标

    private String supportWidth;

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

    public String getSupportWidth() {
        return supportWidth;
    }

    public void setSupportWidth(String supportWidth) {
        this.supportWidth = supportWidth;
    }
}
