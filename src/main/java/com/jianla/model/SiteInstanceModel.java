package com.jianla.model;

/**
 * 发布新建一个site
 * 备份新建一个site
 * 模板初始化新建一个site
 * 当前站点新建一个site
 * 一个site只对应一个，默认有ID=1的默认site提供初始数据
 *
 * @author : zwj
 * @data : 2017/4/29
 */
public class SiteInstanceModel {

    public static final short TYPE_TEMPLATE = 0;//平台模板
    public static final short TYPE_BACKUP = 1;//机构，orgId不为空

    private Long id;

    private Long orgId;

    private Long templateId;//冗余字段，无法更改

    private Long tempSkinId;

    private Short type;

    private Short status;

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

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getTempSkinId() {
        return tempSkinId;
    }

    public void setTempSkinId(Long tempSkinId) {
        this.tempSkinId = tempSkinId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
