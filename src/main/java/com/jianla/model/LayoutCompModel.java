package com.jianla.model;

/**
 * @author : zwj
 * @data : 2017/5/2
 */
public class LayoutCompModel {

    private Long layoutCompId;

    private String layoutType;//固定3种 head,body,foot

    private String remark;

    private String cssName;

    private String transGroup;//同一个转化组可相互转化

    private String mainWidth;

    private String subWidth;

    public Long getLayoutCompId() {
        return layoutCompId;
    }

    public void setLayoutCompId(Long layoutCompId) {
        this.layoutCompId = layoutCompId;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCssName() {
        return cssName;
    }

    public void setCssName(String cssName) {
        this.cssName = cssName;
    }

    public String getTransGroup() {
        return transGroup;
    }

    public void setTransGroup(String transGroup) {
        this.transGroup = transGroup;
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
}
