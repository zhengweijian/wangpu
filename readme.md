# 店铺装修

旺铺实体及其关系

1. 模板（一对多）模板皮肤
2. 模板（关联）网站实例
3. 网站实例（一对多）店铺页面
4. 店铺页面（一对多）布局控件
5. 布局控件

## 店铺页面（Page）
**页面布局**
店铺由页头（header）、内容（bodies）、页尾（footer）三部分组成，
内容部分最多可以有5个

**页面管理**

|页面|说明|可用模块|
|---|---|---|
|首页|导航无法删除|全部|
|店内搜索页|导航无法删除；宝贝分类、宝贝排行榜、宝贝列表无法移动和删除|自定义区、店铺招牌|
|宝贝详情页|导航无法删除；宝贝基础信息、宝贝描述信息、宝贝相关信息无法移动和删除|全部|
|宝贝列表页|导航无法删除；|全部|

淘宝的宝贝详情页、宝贝列表页、自定义页可以创建多个

- shop_detail 旺铺首页（需要装修）
- shop_service 店内搜索页（需要装修？）
- service_detail 宝贝详情页（需要装修？）
- shop_news 机构动态（暂不需要装修）
- shop_about 关于我们（暂不需要装修）


页面管理只有`index`和`search`
页面状态有 未发布、已发布、修改未发布，游客只能查看已发布的，修改的只有自己可见。
页面装修时pageId不改变
更换模板时，所有页面的pageId都改变了

应用模板=新建page，改变currPage
发布模板=拷贝currPage到releasePage，当前currPage.status=已发布
发布后修改模板=currPage.status=修改未发布

备份后恢复，pageId不改变

直接应用该模板时，系统将在自动备份当前装修数据后，用该模板进行初始化

## 页面布局（Layout）
布局组件（LayoutComp）定义了可放置的模块，以及样式类名：

|组件名称|说明|
|---|---|
|页头组件|只接受“店铺招牌”和“导航”两个模块，最多放置2个模块|
|页尾组件|只接受“自定义区”模块，最多放置1个模块|
|页中950组件|只接受950的组件main|
|页中190-750组件|sub，main|
|页中750-190组件|main，sub|
 
布局部件（LayoutWidget）是布局组件填充了模块的结果，整个布局有个css类名

**布局组件的可放置模块规则：**
`[h|b|f][190|750|950]`

第一个是位置限定，第二个位置是尺寸限定。如“h950”、多个如“b950-b190-b750-b550-f950”
 
## 模块（Module） 
模块（Module）介绍：

|模块名|支持布局|
|---|---|
|宝贝排行|b190|
|宝贝分类|b190|
|客服中心|b190|
|友情链接|b190-b950|
|图片轮播|b190-b750-b950|
|宝贝推荐|b190-b750-b950|
|宝贝搜索|b190-b750-b950|
|店铺招牌|h950|
|导航|h950（无法新增和删除）|
|自定义区|b190-b750-b950-f950|

模块控件（ModuleWidget）是布局组件填充了数据的结果，是可视化的组件

## 模板（Template）
- 模板（定义模板）
- 模板皮肤（定义css）
- 模板备份（备份模板，和页面数据）

使用模板初始化页面？

手动备份不超过15个，自动备份不超过5个（发布自动备份，更换模板提示备份）

## 里程碑
1. 模板定义、模板theme/配色 完成


目标：完成布局管理和页面编辑，初步设想为布局管理中拖动模块和布局，在页面编辑中编辑模块数据。



```
【GET】/module/newModuleOpt.htm
opt:add
layout:16344756864-main-1
width:750
module_comp_id:5003
sid:410625239
pageType:4
pageId:1455761552
sectionName:designLayout

message: "操作成功", state: "1", data: {moduleId: 16364570136}

【POST】/module/newModuleOpt.htm

【Query String Paramters】
pageType:4
pageId:1455761552
【Form Data】
opt:add
width:750
module_comp_id:5003
layout:16344756864-main-1
【返回】
<div class="J_TModule" data-widgetid="16364532458"  id="shop16364532458"  data-componentid="5003"  data-spm='110.0.5003-16364532458'  microscope-data='5003-16364532458' data-title="自定义内容区" data-context="b950-b190-b750-b550-f950" data-ismove="1" data-isdel="1" data-isedit="1" data-isadd="1" data-width="880" data-uri="/module/moduleForm.htm?widgetId=16364532458&sid=410625239&pageId=1455761552" data-spm='110.0.5003-16364532458'  microscope-data='5003-16364532458'  >	    	<div class="skin-box tb-module tshop-pbsm tshop-pbsm-shop-self-defined" style="position:relative">
	
        <s class="skin-box-tp"><b></b></s>
		        <div class="skin-box-hd">
            <h3>
				<span>
    			    						    					自定义内容区
						    								</span>
			</h3>
        </div>
		        <div class="skin-box-bd clear-fix">
            <span>
					    			<p style="text-align: center">&nbsp;</p>
                    <p style="text-align: center">&nbsp;自定义内容，可以用来展示店铺特色的宝贝、活动。</p>
                    <p style="text-align: center">&nbsp;</p>
                    <p style="text-align: center">&nbsp;</p>
							</span>
        </div>
        <s class="skin-box-bt"><b></b></s>
	</div>
</div>
```

<!-- false -->
<!-- pageDO是：SitePageDO[id=1455494515,pageName=首页,pageType=1,taeSiteInstanceId=417794675 pageId1:1455494515 pagePartsDO: -->
<!-- isLazy：, pageType是：1 pageId2:1455494515 appID:03068  -->
<!-- requestUri: /module/modulePreview.htm -->
<!-- regionWidth:  -->

- grid-m (main)
- grid-sm (sub-main)
- grid-ms (main-sub)

布局管理
https://siteadmin.taobao.com/layout.htm?spm=a21ar.c-design.0.0.0NVGVQ&sid=417794675&pageId=1455494515
页面预览
https://siteadmin.taobao.com/canvas.htm?sid=417794675&pageId=1455494515
模块编辑页
https://siteadmin.taobao.com/module/edit/itemRecommend.htm?widgetId=16364825072&sid=417794675&pageId=1455494515
