package com.jianla.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : zwj
 * @data : 2017/4/25
 */
@Entity
@Table(name="tshop_layout_widget")
public class TshopLayoutWidget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="layout_widget_id")
    private Long layoutWidgetId;

    @Column(name="layout_comp_id")
    private Long layoutCompId;//布局组件id

    @Column(name="layout_type")
    private String layoutType;//冗余组件type(head、body、foot）

    @Column(name="page_id")
    private Long pageId;//页面id

    @Column(name="display_order")
    private Integer displayOrder;//排序，head为0，foot为0，body为1-5

    @Column(name="max_module")
    private Integer maxModule;//布局最大模块数

    public Long getLayoutWidgetId() {
        return layoutWidgetId;
    }

    public void setLayoutWidgetId(Long layoutWidgetId) {
        this.layoutWidgetId = layoutWidgetId;
    }

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

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getMaxModule() {
        return maxModule;
    }

    public void setMaxModule(Integer maxModule) {
        this.maxModule = maxModule;
    }
}
