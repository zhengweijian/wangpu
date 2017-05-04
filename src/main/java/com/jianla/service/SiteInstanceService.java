package com.jianla.service;

import com.jianla.model.SiteInstanceModel;

/**
 * 站点实例
 * @author : zwj
 * @data : 2017/4/29
 */
public interface SiteInstanceService {

    //没有新增，数据库默认有个ID=1的数据

    //拷贝到平台站点模板（初始化）
    Long copy2Temp(Long templateId, Long tempSkinId);

    //拷贝到用户
    Long copy2Org(Long siteInstanceId, Long orgId);

    SiteInstanceModel getCurrentSite(Long orgId);

    SiteInstanceModel getReleaseSite(Long orgId);

    /**
     * 发布当前网站
     * @param orgId 所属机构
     * @return 发布的站点ID
     */
    Long releaseSite(Long orgId);
}
