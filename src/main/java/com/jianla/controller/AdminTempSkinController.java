package com.jianla.controller;

import com.jianla.model.ShopTempSkinModel;
import com.jianla.service.TempSkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zwj
 * @data : 2017/4/21
 */
@Controller
@RequestMapping("/admin/tempSkin")
public class AdminTempSkinController {

    @Autowired
    private TempSkinService tempSkinService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(ShopTempSkinModel tempSkinModel){
        Long id = tempSkinService.add(tempSkinModel);

        Map<String,Object> json = new HashMap<>();
        json.put("success",true);
        json.put("id",id);
        return json;
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> update(ShopTempSkinModel tempSkinModel){
        tempSkinService.update(tempSkinModel);

        Map<String,Object> json = new HashMap<>();
        json.put("success",true);
        return json;
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delete(Long skinId){
        tempSkinService.delete(skinId);

        Map<String,Object> json = new HashMap<>();
        json.put("success",true);
        return json;
    }

}
