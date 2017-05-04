package com.jianla.entity;

import javax.persistence.*;

/**
 * 站点被Tshop（currentSiteId、releaseSiteId）、TtempSite（模板初始化站点）关联
 * @author : zwj
 * @data : 2017/4/29
 */
@Entity
@Table(name="tshop_site_instance")
public class TshopSiteInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="org_id")
    private Long orgId;

    @Column(name="template_id",updatable = false)
    private Long templateId;//冗余字段，无法更改

    @Column(name="temp_skin_id")
    private Long tempSkinId;

    @Column(name="type")
    private Short type;

    @Column(name="status")
    private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getTempSkinId() {
        return tempSkinId;
    }

    public void setTempSkinId(Long tempSkinId) {
        this.tempSkinId = tempSkinId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}
