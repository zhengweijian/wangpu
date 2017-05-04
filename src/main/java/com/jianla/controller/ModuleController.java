package com.jianla.controller;

import com.jianla.model.LayoutLocation;
import com.jianla.service.ModuleService;
import com.jianla.service.ModuleWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zwj
 * @data : 2017/4/22
 */
@Controller
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ModuleWidgetService moduleWidgetService;

    //获取模块组件
    @RequestMapping(value="getModules",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getModules(Long pageId, Integer width){
        Map<String,Object> map =  new HashMap<>();
        map.put("success",true);
        map.put("moduleInfoList",moduleService.findEnabledModules(width));
        return map;
    }

    //增加模块控件
    @RequestMapping(value="newModule",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> newModule(String layout,Long module_comp_id,Long pageId){
        Long id = moduleWidgetService.addModuleWidget(pageId, module_comp_id, new LayoutLocation(layout));
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("moduleWidgetId", id);
        return map;
    }

    @RequestMapping(value = "delModule",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delModule(Long pageId,Long moduleWidgetId){
        moduleWidgetService.delModuleWidget(pageId,moduleWidgetId);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping(value="moveModule",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> moveModule(Long pageId,Long moduleWidgetId,String from,String to){
        moduleWidgetService.moveModuleWidget(pageId,moduleWidgetId,new LayoutLocation(from),new LayoutLocation(to));
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    //编辑模块组件表单
    @RequestMapping(value = "moduleForm",method = RequestMethod.GET)
    public String moduleForm(Long pageId,Long widgetId){
        return "shop/module_widget_edit";
    }
}
