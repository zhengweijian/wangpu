package com.jianla.model;

/**
 * @author : zwj
 * @data : 2017/4/22
 */
public class ShopPageModel {

    private Long id;

    private Long orgId;//冗余，等于siteInstance的orgId

    private Long siteInstanceId;//站点实例id

    private Short pageType;

    private String pageName;

    private Integer maxLayout;

    private Integer maxModule;

    //页头 region:hd、bd
    private String hdBgcolor;//颜色

    private Boolean hdShowBgcolor;//是否展示

    private String hdBgimg;//背景图

    //页面
    private String bdBgcolor;//颜色

    private Boolean bdShowBgcolor;//是否展示

    private String bdBgimg;//背景图

    //高级
    private String customCss;//自定义css

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getSiteInstanceId() {
        return siteInstanceId;
    }

    public void setSiteInstanceId(Long siteInstanceId) {
        this.siteInstanceId = siteInstanceId;
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
