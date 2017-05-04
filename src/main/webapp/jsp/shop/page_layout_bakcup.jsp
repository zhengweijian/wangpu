<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>店铺装修-布局管理</title>

    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/wangpu/index.css">
</head>
<body>
<div id="page" class="shop-jianla">
    <div class="vl-navbar">
        <div class="vl-brand">
            <h1>检啦旺铺</h1>
        </div>
        <div class="vl-menu">
            <ul class="vl-menu-bar">
                <li><a href="/page/manage.html">页面管理</a></li>
                <li><a href="/template/manage.html">模板管理</a></li>
            </ul>
        </div>
    </div>
    <div class="main-wrapper main-wrapper-design-mode wpst-toolbar-show">
        <div class="vl-sidebar">
            <!-- 工具条 -->
            <ul class="tab-bar">
                <li class="modules J_ToolbarItem selected" data-slide="modules">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon-th-large"></b>
                        <div class="">模块</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <li class="theme J_ToolbarItem" data-slide="theme">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon glyphicon-film"></b>
                        <div class="">配色</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <li class="page-head ToolbarItem" data-slide="page-head">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon-align-justify"></b>
                        <div class="">页头</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <li class="page ToolbarItem" data-slide="page">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon-list-alt"></b>
                        <div class="">页面</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <li class="css ToolbarItem" data-slide="css">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon-cog"></b>
                        <div class="">CSS</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
            </ul>
            <!-- 工具条展开 -->
            <ul class="toolbar">
                <li class="slide modules-slide selected">
                    <b class="glyphicon glyphicon-remove close-icon"></b>
                    <div class="inside">
                        <p>选择所需模块，并拖动至相应位置</p>
                        <div class="sizes clearfix">
                            <span class="J_SizeSelect size-all size-selected" data-size>所有</span>
                            <span class="J_SizeSelect size-950" data-size="950">950</span>
                            <span class="J_SizeSelect size-190" data-size="190">190</span>
                            <span class="J_SizeSelect size-750" data-size="750">750</span>
                        </div>
                        <div class="modules-box">
                            <ul class="module-list">
                                <li class="J_NModule" data-modid='' data-max-append="40" data-context="b950-b190">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                                <li class="J_NModule">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                                <li class="J_NModule">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                                <li class="J_NModule">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                                <li class="J_NModule">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                                <li class="J_NModule">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                                <li class="J_NModule">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                                <li class="J_NModule">
									<span class="pic">
										<img src="https://img.alicdn.com/tps/TB1yujwMXXXXXXjXXXXXXXXXXXX-38-38.png"
                                             alt="服务推荐">
									</span>
                                    <span title="服务推荐" class="content">服务推荐</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li class="slide theme-slide">配色（修改将应用到所有页面）</li>
                <li class="slide page-head-slide">页头配置（应用到所有页面、重置当前页）</li>
                <li class="slide page-slide">页面配置（应用到所有页面、重置当前页）</li>
                <li class="slide css-slide">css配置（需要订购才能使用
                    {message: "操作失败,你没有权限使用完全自定义Css功能"}）
                </li>
            </ul>
        </div>
        <div class="vl-main">
            <div class="design-navigation-wrap">
                <div class="design-page-select">
                    <select name="" id="" class="form-control input-sm">
                        <option value="">旺铺首页</option>
                        <option value="">店内搜索页</option>
                        <option value="">宝贝详情页</option>
                    </select>
                </div>
                <ul class="design-mode-select btn-group">
                    <li><a href="#" class="btn btn-default btn-sm">页面编辑</a></li>
                    <li><a href="#" class="btn btn-default btn-sm">布局管理</a></li>
                </ul>
                <div class="page-operation-btns">
                    <a href="#" class="btn btn-default btn-sm">备份</a>
                    <a href="#" class="btn btn-default btn-sm">预览</a>
                    <a href="#" class="btn btn-default btn-sm">发布站点</a>
                </div>
            </div>
            <div class="page-container">
                <div class="vl-container">
                    <!--
                    <iframe class="page-to-design" src="/page/canvas.html?pageId=" frameborder="0" style="height: 2661px;width: 1456px;display: block;">
                    </iframe> -->
                    <!-- 页面开始 -->
                    <div class="vl-layout-container">
                        <div class="page-layout-edit" data-max-layout="5" data-max-module="40">
                            <!-- head -->
                            <div class="layout-hd">
                                <div v-for="layout in page.hd" class="layout J_TLayout" :class="layout.cssName"
                                     :data-max="layout.maxModule" :data-widgetid="layout.layoutWidgetId" :data-compid="layout.layoutCompId">
                                    <p class="title"><span>店铺页头</span></p>
                                    <div class="col-main">
                                        <div v-for="module in layout.main" class="main-warp J_TRegion" data-modules="main" data-width="layout.mainWidth">
                                            <div class="tb-module J_TModule" :data-widgetid="module.moduleWidgetId" :data-compid="module.moduleId"
                                                 :data-pageid="layout.pageId" :data-title="module.title" >
                                                <span>{{module.title}}</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- body -->
                            <div class="layout-bd">
                                <div v-for="layout in page.bd" class="layout J_TLayout" :class="layout.cssName"
                                     :data-max="layout.maxModule" :data-widgetid="layout.layoutWidgetId" :data-compid="layout.layoutCompId">
                                    <p class="layout-cl">
                                        <a class="move-up" title="上移"></a>
                                        <a class="move-down" title="下移"></a>
                                        <%--<a class="edit" title="编辑"></a>--%>
                                        <a class="del" title="删除"></a>
                                    </p>
                                    <div v-for="module in layout.main" class="main-warp J_TRegion" data-modules="main" data-width="layout.mainWidth">
                                        <div class="tb-module J_TModule" :data-widgetid="module.moduleWidgetId" :data-compid="module.moduleId"
                                             :data-pageid="layout.pageId" :data-title="module.title" >
                                            <span>{{module.title}}</span>
                                            <a href="#del" class="act-del"></a>
                                        </div>
                                    </div>
                                    <div class="col-main">
                                        <div class="main-wrap J_TRegion" data-width="b950">
                                            <div class="tb-module J_TModule" data-ismove="1">
                                                <span>图片轮播</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule" data-ismove="1">
                                                <span>图片轮播2</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule" data-ismove="1">
                                                <span>图片轮播3</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="layout grid-sm J_TLayout">
                                    <div class="col-main">
                                        <div class="main-wrap J_TRegion" data-width="b750">
                                            <div class="tb-module J_TModule">
                                                <span>服务推荐</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule">
                                                <span>宝贝推荐</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sub">
                                        <div class="main-wrap J_TRegion" data-width="b190">
                                            <div class="tb-module J_TModule">
                                                <span>宝贝排行榜</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule">
                                                <span>自定义内容区</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule">
                                                <span>服务分类</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="layout grid-ms J_TLayout" data-id="layoutid">
                                    <div class="col-main">
                                        <div class="main-wrap J_TRegion" data-width="b750" data-modules="main">
                                            <div class="tb-module J_TModule" data-ismove="1">
                                                <span>服务推荐</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule" data-ismove="1">
                                                <span>自定义内容区</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule" data-ismove="1">
                                                <span>宝贝推荐</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sub">
                                        <div class="main-wrap J_TRegion" data-width="b190" data-modules="sub">
                                            <div class="tb-module J_TModule" data-ismove="1" data-widgetid="widgetid">
                                                <span>宝贝排行榜</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                            <div class="tb-module J_TModule" data-ismove="1">
                                                <span>服务分类</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="new-layout">
                                <a href="#" class="add-layout">添加布局单元</a>
                            </div>
                            <!-- foot -->
                            <div class="layout-ft">
                                <div class="layout grid-m" data-max="2" data-id="" data-compid="23"
                                     data-widgetid="部件id">

                                    <div class="col-main">
                                        <div class="main-warp J_TRegion" data-modules="main" data-width="h950"
                                             data-max="2">

                                            <div class="tb-module J_TModule" data-widgetid="" data-compid=""
                                                 data-title="导航" data-context="h950" data-ismove="1" data-isdel="0"
                                                 data-isedit="1"
                                                 data-url="/module/moduleForm.htm?widgetId=16364825066&sid=417794675&pageId=1455494515">
                                                <span>自定义内容区</span>
                                                <a href="#del" class="act-del"></a>
                                            </div>
                                        </div>
                                    </div>
                                    <p class="title"><span>店铺页尾</span></p>
                                </div>
                            </div>
                            <div class="system-footer">
                                <p>检啦网络科技有限公司 版权所有</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 页面结束 -->
            </div>
        </div>
    </div>
</div>
</div>

<div class="vl-design-mode-shim">

</div>
<bar class="selected-module-mask">

</bar>
<script src="/js/wangpu/jquery.module-drag.js"></script>
<script src="/js/wangpu/index.js"></script>
<script src="/js/vue.min.js"></script>
<script>
var vm = new Vue({
    el:'.vl-container',
    data:{
        page : {}
    },
    methods:{

    },
    mounted:function () {
        var self = this;
        $.get('/page/getLayout.json?pageId=${page.id}',function (data) {
            if(typeof(data)!="object") data=JSON.parse(data);
            if(data && data.success){
                self.page = data.data;
            }
        })
    }
})
</script>
</body>
</html>
