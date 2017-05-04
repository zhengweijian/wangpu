package com.jianla.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 机构模板备份
 * @author : zwj
 * @data : 2017/4/29
 */
@Entity
@Table(name="tshop_temp_backup")
public class TshopTempBackup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="backup_id")
    private Long backupId;

    @Column(name="org_id")
    private Long orgId;//机构ID

    @Column(name="site_instance_id")
    private Long siteInstanceId;//网站实例ID

    @Column(name="backup_name")
    private String backupName;//备份名称

    @Column(name="backup_desc")
    private String backupDesc;//备份描述

    @Column(name="backup_time")
    private Date backupTime;//备份时间

    public Long getBackupId() {
        return backupId;
    }

    public void setBackupId(Long backupId) {
        this.backupId = backupId;
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

    public String getBackupName() {
        return backupName;
    }

    public void setBackupName(String backupName) {
        this.backupName = backupName;
    }

    public String getBackupDesc() {
        return backupDesc;
    }

    public void setBackupDesc(String backupDesc) {
        this.backupDesc = backupDesc;
    }

    public Date getBackupTime() {
        return backupTime;
    }

    public void setBackupTime(Date backupTime) {
        this.backupTime = backupTime;
    }
}
