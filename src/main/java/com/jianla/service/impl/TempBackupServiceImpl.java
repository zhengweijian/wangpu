package com.jianla.service.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.entity.Tshop;
import com.jianla.entity.TshopSiteInstance;
import com.jianla.entity.TshopTempBackup;
import com.jianla.model.TempBackModel;
import com.jianla.model.base.Page;
import com.jianla.service.SiteInstanceService;
import com.jianla.service.TempBackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/30
 */
@Service
@Transactional
public class TempBackupServiceImpl implements TempBackupService {

    @Autowired
    private BaseDaoI<TshopTempBackup> tempBackupDao;

    @Autowired
    private BaseDaoI<Tshop> shopDao;

    @Autowired
    private BaseDaoI<TshopSiteInstance> siteInstanceDao;

    @Autowired
    private SiteInstanceService siteInstanceService;

    @Override
    public Long saveBackup(Long orgId, String backupName, String backupDesc) {

        Tshop tshop = shopDao.get("from Tshop t where t.orgId = ?", new Object[]{orgId});
        if(tshop==null) throw new RuntimeException("找不到店铺 org id ="+orgId);
        if(tshop.getCurrentSiteId()==null) throw new RuntimeException("未开启旺铺 shop id = "+tshop.getId());

        TshopTempBackup tshopTempBackup = new TshopTempBackup();
        tshopTempBackup.setOrgId(orgId);
        tshopTempBackup.setBackupName(backupName);
        tshopTempBackup.setBackupDesc(backupDesc);
        tshopTempBackup.setBackupTime(new Date());

        //copy backup site
        Long backupSiteId = siteInstanceService.copy2Org(tshop.getCurrentSiteId(), orgId);
        tshopTempBackup.setSiteInstanceId(backupSiteId);

        tempBackupDao.save(tshopTempBackup);
        return tshopTempBackup.getBackupId();
    }

    @Override
    public void delBackup(Long orgId,Long backupId) {
        TshopTempBackup tshopTempBackup = tempBackupDao.get(TshopTempBackup.class, backupId);
        if(!tshopTempBackup.getOrgId().equals(orgId)){
            throw new RuntimeException("未授权异常");
        }
        Long siteInstanceId = tshopTempBackup.getSiteInstanceId();
        TshopSiteInstance tshopSiteInstance = siteInstanceDao.get(TshopSiteInstance.class, siteInstanceId);
        siteInstanceDao.delete(tshopSiteInstance);
        tempBackupDao.delete(tshopTempBackup);
    }

    @Override
    public void applyBackup(Long orgId, Long backupId) {
        Tshop tshop = shopDao.get("from Tshop t where t.orgId = ?", new Object[]{orgId});
        if(tshop==null) throw new RuntimeException("找不到店铺 org id ="+orgId);

        TshopTempBackup tshopTempBackup = tempBackupDao.get(TshopTempBackup.class, backupId);
        if(!tshopTempBackup.getOrgId().equals(orgId)){
            throw new RuntimeException("未授权异常");
        }
        //系统备份老版本
        TshopTempBackup systemBackup = new TshopTempBackup();
        systemBackup.setOrgId(orgId);
        systemBackup.setBackupName("系统备份（切换模板）");
        systemBackup.setBackupDesc("系统只保留最近的100次备份");
        systemBackup.setSiteInstanceId(tshop.getCurrentSiteId());
        //不使用备份的site，copy一个并修改当前site
        Long newSiteId = siteInstanceService.copy2Org(tshopTempBackup.getSiteInstanceId(), orgId);
        tshop.setCurrentSiteId(newSiteId);
        shopDao.update(tshop);
    }

    @Override
    public Page<TempBackModel> find(Page page, TempBackModel tempBackModel) {
        String hql = "from TshopTempBackup t where 1=1";
        List<Object> values = new ArrayList<>();
        if(tempBackModel.getOrgId()!=null){
            hql += " and t.orgId = ?";
            values.add(tempBackModel.getOrgId());
        }
        if (tempBackModel.getBackupName() != null) {
            hql+=" and t.backupName = ?";
            values.add(tempBackModel.getBackupName());
        }
        List<TshopTempBackup> tshopTempBackups = tempBackupDao.find(hql, values,page.getPageNo(),page.getPageSize());
        int count = tempBackupDao.countHqlResult(hql, values);
        page.setTotalCount(count);
        page.setResult(tshopTempBackups);
        return page;
    }
}
