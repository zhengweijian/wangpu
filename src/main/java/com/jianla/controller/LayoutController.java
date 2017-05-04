package com.jianla.controller;

import com.jianla.model.LayoutCompModel;
import com.jianla.service.LayoutCompService;
import com.jianla.service.LayoutWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 为了安全，要验证page归属
 * @author : zwj
 * @data : 2017/4/28
 */
@Controller
@RequestMapping("/layout")
public class LayoutController {

    @Autowired
    private LayoutWidgetService layoutWidgetService;

    @Autowired
    private LayoutCompService layoutCompService;

    @RequestMapping(value="/getBodyLayout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getBodyLayout(){
        List<LayoutCompModel> bodyLayout = layoutCompService.findBodyLayout();
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", bodyLayout);
        return map;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(Long pageId, Long layoutCompId){
        Long layoutWidgetId = layoutWidgetService.addLayoutWidget(pageId,layoutCompId);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("layoutWidgetId",layoutWidgetId);
        return map;
    }

    @RequestMapping(value="/move",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> move(Long pageId,Long layoutWidgetId,String direction){
        Map<String,Object> map = new HashMap<>();
        int directionInt;
        if (direction.equals("up")) {
            directionInt = -1;
        } else if (direction.equals("down")) {
            directionInt = 1;
        } else {
            map.put("success",false);
            return map;
        }

        layoutWidgetService.moveLayout(pageId,layoutWidgetId,directionInt);
        map.put("success",true);
        return map;
    }

    @RequestMapping(value="/replace",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> replace(Long pageId,Long layoutWidgetId,Long descLayoutCompId){
        layoutWidgetService.replaceLayout(pageId,layoutWidgetId,descLayoutCompId);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping(value="/del",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> del(Long pageId,Long layoutWidgetId){
        layoutWidgetService.delLayout(pageId,layoutWidgetId);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }
}
