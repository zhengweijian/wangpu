package com.jianla.controller;

import com.jianla.Constants;
import com.jianla.model.ShopTempSkinModel;
import com.jianla.model.ShopTemplateModel;
import com.jianla.service.TempSkinService;
import com.jianla.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  发布后的模板有默认页面，机构使用这个pageId创建页面
 *
 * @author : zwj
 * @data : 2017/4/21 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private TempSkinService tempSkinService;

    //机构模板管理
    @RequestMapping(value = "manage",method = RequestMethod.GET)
    public String templateManage(){
        return "shop/template_manage";
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(){
        Long orgId = Constants.getOrgId();
        List<ShopTemplateModel> list = templateService.findMyTemp(orgId);
        Map<String,Object> json = new HashMap<>();
        json.put("success",true);
        json.put("data",list);
        return json;
    }

    @RequestMapping(value = "/skin/list",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> skinList(Long templateId){
        List<ShopTempSkinModel> skinList = tempSkinService.findByTempId(templateId);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", skinList);
        return map;
    }

}
