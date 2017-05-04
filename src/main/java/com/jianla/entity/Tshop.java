package com.jianla.entity;

import javax.persistence.*;

/**
 * @author : zwj
 * @data : 2017/4/20
 */
@Entity
@Table(name="tshop")
public class Tshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="org_id")
    private Long orgId;

    @Column(name="current_site_id")
    private Long currentSiteId;//如果为空则创建

    @Column(name="released_site_id")
    private Long releasedSiteId;//如果为空则没有开启旺铺

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

    public Long getCurrentSiteId() {
        return currentSiteId;
    }

    public void setCurrentSiteId(Long currentSiteId) {
        this.currentSiteId = currentSiteId;
    }

    public Long getReleasedSiteId() {
        return releasedSiteId;
    }

    public void setReleasedSiteId(Long releasedSiteId) {
        this.releasedSiteId = releasedSiteId;
    }
}
