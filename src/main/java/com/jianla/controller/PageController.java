package com.jianla.controller;

import com.jianla.Constants;
import com.jianla.model.LayoutWidgetModel;
import com.jianla.model.PageStruct;
import com.jianla.model.ShopPageModel;
import com.jianla.model.SiteInstanceModel;
import com.jianla.service.LayoutWidgetService;
import com.jianla.service.ShopPageService;
import com.jianla.service.SiteInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zwj
 * @data : 2017/4/22
 */
@RequestMapping("/page")
@Controller
public class PageController {

    @Autowired
    private ShopPageService shopPageService;

    @Autowired
    private SiteInstanceService siteInstanceService;

    @Autowired
    private LayoutWidgetService layoutWidgetService;

    //店铺装修
    @RequestMapping(value = "/design",method = RequestMethod.GET)
    public String design(Long pageId, Model model){
        ShopPageModel shopPageModel;
        if(pageId==null){
            Long orgId = Constants.getOrgId();
            SiteInstanceModel currentSite = siteInstanceService.getCurrentSite(orgId);
            shopPageModel = shopPageService.getIndexPageBySite(currentSite.getId());
        }else{
            shopPageModel = shopPageService.getById(pageId);
        }
        model.addAttribute("page",shopPageModel);
        model.addAttribute("sitePages",shopPageService.findBySite(shopPageModel.getSiteInstanceId()));
        model.addAttribute("op","design");

        return "shop/page_framework";
    }

    //布局管理
    @RequestMapping(value = "layout",method = RequestMethod.GET)
    public String layout(Long pageId, Model model){
        ShopPageModel shopPageModel;
        if(pageId==null){
            Long orgId = Constants.getOrgId();
            SiteInstanceModel currentSite = siteInstanceService.getCurrentSite(orgId);
            shopPageModel = shopPageService.getIndexPageBySite(currentSite.getId());
        }else{
            shopPageModel = shopPageService.getById(pageId);
        }
        model.addAttribute("page",shopPageModel);
        model.addAttribute("sitePages",shopPageService.findBySite(shopPageModel.getSiteInstanceId()));
        model.addAttribute("op","layout");

        return "shop/page_framework";
    }

    @RequestMapping(value = "/getLayout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getLayout(Long pageId){
        PageStruct pageStruct = new PageStruct();
        ShopPageModel shopPageModel = shopPageService.getById(pageId);
        pageStruct.setMaxLayout(shopPageModel.getMaxLayout());
        pageStruct.setMaxModule(shopPageModel.getMaxModule());

        LayoutWidgetModel headByPageId = layoutWidgetService.getHeadByPageId(pageId);
        LayoutWidgetModel footByPageId = layoutWidgetService.getFootByPageId(pageId);
        pageStruct.setHd(Arrays.asList(headByPageId));
        pageStruct.setFt(Arrays.asList(footByPageId));
        pageStruct.setBd(layoutWidgetService.findBodyByPageId(pageId));

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("data",pageStruct);
        return map;
    }

    //创建页面
    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addPage(Long templateId,Long tempSkinId,Short pageType){
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }
}
