package com.jianla.controller;

import com.jianla.Constants;
import com.jianla.model.TempBackModel;
import com.jianla.model.base.Page;
import com.jianla.service.TempBackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zwj
 * @data : 2017/5/3
 */
@Controller
@RequestMapping("/backup")
public class BackupController {

    @Autowired
    private TempBackupService tempBackupService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(String backupName,String backupDesc){
        Long orgId = Constants.getOrgId();
        //备份当前站点为模板
        Long id = tempBackupService.saveBackup(orgId,backupName,backupDesc);

        Map<String,Object> map = new HashMap<>();
        map.put("success", true);
        map.put("id",id);
        return map;
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> del(Long backupId){
        Long orgId = Constants.getOrgId();
        tempBackupService.delBackup(orgId,backupId);

        Map<String,Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(Page page){
        Long orgId = Constants.getOrgId();
        TempBackModel tempBackModel = new TempBackModel();
        tempBackModel.setOrgId(orgId);
        page = tempBackupService.find(page,tempBackModel);
        Map<String,Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data",page);
        return map;
    }

}
