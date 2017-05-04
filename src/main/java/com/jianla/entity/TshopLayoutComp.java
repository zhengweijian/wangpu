package com.jianla.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 布局组件
 * @author : zwj
 * @data : 2017/4/25
 */
@Entity
@Table(name="tshop_layout_comp")
public class TshopLayoutComp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="layout_comp_id")
    private Long layoutCompId;

    @Column(name="layout_type")
    private String layoutType;//固定3种 head,body,foot

    @Column(name="remark")
    private String remark;

    @Column(name="css_name")
    private String cssName;

    @Column(name="trans_group")
    private String transGroup;//同一个转化组可相互转化

    @Column(name="main_width")
    private String mainWidth;

    @Column(name="sub_width")
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
