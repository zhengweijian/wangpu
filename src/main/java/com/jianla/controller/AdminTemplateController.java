package com.jianla.controller;

import com.jianla.Constants;
import com.jianla.form.ShopTemplateForm;
import com.jianla.model.ShopPageModel;
import com.jianla.model.ShopTempSkinModel;
import com.jianla.model.ShopTemplateModel;
import com.jianla.service.ShopPageService;
import com.jianla.service.TemplateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 官方默认配置一个页面后上传展示图片后才能发布
 *
 * @author : zwj
 * @data : 2017/4/22
 */
@Controller
@RequestMapping("/admin/template")
public class AdminTemplateController {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private ShopPageService shopPageService;

    //管理员模板管理
    @RequestMapping(value="center",method = RequestMethod.GET)
    public String templateCenter(){
        Constants.requiredAdmin();
        return "shop/template_center";
    }

    @RequestMapping(value="all",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> all(){
        Constants.requiredAdmin();
        List<ShopTemplateModel> list = templateService.findAll();
        Map<String,Object> json = new HashMap<>();
        json.put("success",true);
        json.put("data",list);
        return json;
    }

    //新建模板
    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(ShopTemplateForm form){
        Constants.requiredAdmin();
        ShopTemplateModel templateModel = new ShopTemplateModel();
        BeanUtils.copyProperties(form,templateModel);
        templateModel.setType(ShopTemplateModel.TYPE_OFFICIAL);
        Long templateId = templateService.add(templateModel);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("id",templateId);
        return map;
    }

    //修改模板
    @RequestMapping(value="update",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> update(Long id,ShopTemplateForm form){
        Constants.requiredAdmin();
        ShopTemplateModel templateModel = templateService.getById(id);
        BeanUtils.copyProperties(form,templateModel);
        templateService.update(templateModel);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("id",id);
        return map;
    }

    //修改图片
    @RequestMapping(value="uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadImg(@RequestParam Long templateId, @RequestParam String imgUrl){
        Constants.requiredAdmin();
        ShopTemplateModel templateModel = templateService.getById(templateId);
        templateModel.setImgUrl(imgUrl);
        templateService.update(templateModel);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }

    //下架模板
    @RequestMapping(value="unRelease",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delete(Long templateId){
        Constants.requiredAdmin();
        ShopTemplateModel templateModel = templateService.getById(templateId);
        templateModel.setStatus(ShopTemplateModel.STATUS_INIT);
        templateService.update(templateModel);

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("id",templateId);
        return map;
    }

    //发布模板
    @RequestMapping(value="release",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> release(Long templateId){
        Constants.requiredAdmin();
        ShopTemplateModel templateModel = templateService.getById(templateId);

        Map<String,Object> map = new HashMap<>();
        if(templateModel.getInitSiteId()!=null && templateModel.getImgUrl()!=null){
            templateModel.setStatus(ShopTemplateModel.STATUS_RELEASED);
            templateService.update(templateModel);
            map.put("success",true);
            map.put("id",templateId);
        }else{
            map.put("success",false);
            map.put("msg","模板发布必须增加初始化页面，和上传展示图片");
        }
        return map;
    }

    //模板初始化网站
    @RequestMapping(value="init_site",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> init_site(Long templateId){
        Constants.requiredAdmin();
        Map<String,Object> map = new HashMap<>();

        ShopTemplateModel templateModel = templateService.getById(templateId);
        Long initSiteId = templateModel.getInitSiteId();
        if(initSiteId==null){
            List<ShopTempSkinModel> skinList = templateModel.getSkinList();
            if(CollectionUtils.isEmpty(skinList)){
                map.put("success",false);
                map.put("msg","请先增加模板配色");
                return map;
            }
            initSiteId = templateService.initSite(skinList.get(0).getSkinId());
        }
        ShopPageModel indexPage = shopPageService.getIndexPageBySite(initSiteId);
        map.put("success",true);
        map.put("pageId",indexPage.getId());
        return map;
    }
}
