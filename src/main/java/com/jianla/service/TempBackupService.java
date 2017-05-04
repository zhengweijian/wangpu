package com.jianla.service;

import com.jianla.model.TempBackModel;
import com.jianla.model.base.Page;

/**
 * @author : zwj
 * @data : 2017/4/30
 */
public interface TempBackupService {

    /**
     * 保存备份
     * @param orgId
     * @param backupName
     * @param backupDesc
     * @return 备份ID
     */
    Long saveBackup(Long orgId,String backupName,String backupDesc);

    void delBackup(Long orgId,Long backupId);

    /**
     * 启用备份
     * @param backupId 备份id
     */
    void applyBackup(Long orgId,Long backupId);

    Page<TempBackModel> find(Page page,TempBackModel tempBackModel);
}
