package com.jianla.entity;

import javax.persistence.*;

/**
 * 模板初始化的网站实例 关系（一对一）
 * @author : zwj
 * @data : 2017/4/29
 */
@Entity
@Table(name="tshop_temp_site")
public class TshopTempSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="template_id",unique = true)
    private Long templateId;

    @Column(name="site_instance_id",unique = true)
    private Long siteInstanceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getSiteInstanceId() {
        return siteInstanceId;
    }

    public void setSiteInstanceId(Long siteInstanceId) {
        this.siteInstanceId = siteInstanceId;
    }
}
