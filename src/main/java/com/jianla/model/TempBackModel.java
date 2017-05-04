package com.jianla.model;

import java.util.Date;

/**
 * 模板备份
 * @author : zwj
 * @data : 2017/4/30
 */
public class TempBackModel {

    private Long backupId;

    private Long orgId;//机构ID

    private Long siteInstanceId;//网站实例ID

    private String backupName;//备份名称

    private String backupDesc;//备份描述

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
