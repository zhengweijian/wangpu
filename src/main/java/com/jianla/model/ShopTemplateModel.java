package com.jianla.model;

import java.util.Date;
import java.util.List;

/**
 * 店铺模板
 * @author : zwj
 * @data : 2017/4/20
 */
public class ShopTemplateModel {

    public static final short TYPE_OFFICIAL= 1;//官方类型
    public static final short TYPE_BACKUP = 2;//用户备份

    public static final short STATUS_INIT= 0;//创建状态
    public static final short STATUS_DELETED= -1;//删除状态
    public static final short STATUS_RELEASED= 1;//发布状态

    private Long id;

    private String name;//模板名称

    private String owner;//拥有者

    private String deadLineTime;//截止时间

    private String price;//价格

    private String imgUrl;//展示图片

    private Date createTime;

    private Short type;//1为官方模板

    private Long initSiteId;//初始化网站id

    private Short status;//状态

    //ext
    private Boolean inUse;//当前是否在使用

    private List<ShopTempSkinModel> skinList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<ShopTempSkinModel> getSkinList() {
        return skinList;
    }

    public void setSkinList(List<ShopTempSkinModel> skinList) {
        this.skinList = skinList;
    }

    public String getDeadLineTime() {
        return deadLineTime;
    }

    public void setDeadLineTime(String deadLineTime) {
        this.deadLineTime = deadLineTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getInitSiteId() {
        return initSiteId;
    }

    public void setInitSiteId(Long initSiteId) {
        this.initSiteId = initSiteId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
