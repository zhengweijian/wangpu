package com.jianla.entity;

import javax.persistence.*;

/**
 * 店铺页面（只管数据）
 * 更换模板更换了id
 *
 * @author : zwj
 * @data : 2017/4/20
 */
@Entity
@Table(name="tshop_page")
public class TshopPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="org_id")
    private Long orgId;//冗余，等于siteInstance的orgId

    @Column(name="site_instance_id")
    private Long siteInstanceId;//站点实例id

    @Column(name="page_type")
    private Short pageType;

    @Column(name="page_name")
    private String pageName;

    @Column(name="max_layout")
    private Integer maxLayout;

    @Column(name="max_module")
    private Integer maxModule;

    //页头 region:hd、bd
    @Column(name="hd_bgcolor")
    private String hdBgcolor;//颜色

    @Column(name="hd_show_bgcolor")
    private Boolean hdShowBgcolor;//是否展示

    @Column(name="hd_bgimg")
    private String hdBgimg;//背景图

    //页面
    @Column(name="bd_bgcolor")
    private String bdBgcolor;//颜色

    @Column(name="bd_show_bgcolor")
    private Boolean bdShowBgcolor;//是否展示

    @Column(name="bd_bgimg")
    private String bdBgimg;//背景图

    //高级
    @Column(name="custom_css")
    private String customCss;//自定义css

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSiteInstanceId() {
        return siteInstanceId;
    }

    public void setSiteInstanceId(Long siteInstanceId) {
        this.siteInstanceId = siteInstanceId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Short getPageType() {
        return pageType;
    }

    public void setPageType(Short pageType) {
        this.pageType = pageType;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getHdBgcolor() {
        return hdBgcolor;
    }

    public void setHdBgcolor(String hdBgcolor) {
        this.hdBgcolor = hdBgcolor;
    }

    public Boolean getHdShowBgcolor() {
        return hdShowBgcolor;
    }

    public void setHdShowBgcolor(Boolean hdShowBgcolor) {
        this.hdShowBgcolor = hdShowBgcolor;
    }

    public String getHdBgimg() {
        return hdBgimg;
    }

    public void setHdBgimg(String hdBgimg) {
        this.hdBgimg = hdBgimg;
    }

    public String getBdBgcolor() {
        return bdBgcolor;
    }

    public void setBdBgcolor(String bdBgcolor) {
        this.bdBgcolor = bdBgcolor;
    }

    public Boolean getBdShowBgcolor() {
        return bdShowBgcolor;
    }

    public void setBdShowBgcolor(Boolean bdShowBgcolor) {
        this.bdShowBgcolor = bdShowBgcolor;
    }

    public String getBdBgimg() {
        return bdBgimg;
    }

    public void setBdBgimg(String bdBgimg) {
        this.bdBgimg = bdBgimg;
    }

    public String getCustomCss() {
        return customCss;
    }

    public void setCustomCss(String customCss) {
        this.customCss = customCss;
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
