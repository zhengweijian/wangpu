<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib_includes.jsp" %>
<html>
<head>
    <%--首页，店内搜索页，宝贝详情页，宝贝分类页，自定义页--%>
    <title>店铺装修</title>
    <style>
        .page-to-design {
            display: none;
            margin: 0 auto;
            background: #fff;
        }
    </style>
</head>
<body>
<div id="page" class="shop-jianla">
    <div class="topbar">
        <ul>
            <li>检啦旺铺-专业版</li>
            <li>页面装修</li>
            <li>模板管理</li>
        </ul>
    </div>
    <div class="main-wrapper">
        <div class="vl-sidebar">
            <%--工具条--%>
            <ul class="tab-bar">
                <li>模块</li>
                <li>配色</li>
                <li>页头</li>
                <li>页面</li>
                <li>CSS</li>
            </ul>
            <ul class="toolbar">
                <li class="slide modules-slide selected">模块侧边栏</li>
                <li class="slide theme-slide">配色（修改将应用到所有页面）</li>
                <li class="slide page-head-slide">页头配置（应用到所有页面、重置当前页）</li>
                <li class="slide page-slide">页面配置（应用到所有页面、重置当前页）</li>
                <li class="slide css-slide">css配置（需要订购才能使用
                    {message: "操作失败,你没有权限使用完全自定义Css功能"}）</li>
            </ul>
        </div>
        <div class="vl-main">
            <div class="design-navigation-wrap">
                <div class="design-page-select">
                    <select name="" id="">
                        <option value="">首页</option>
                        <option value="">店内搜索页</option>
                        <option value="">宝贝详情页</option>
                        <option value="">宝贝分类页</option>
                        <option value="">自定义页</option>
                    </select>
                </div>
                <ul class="design-mode-select">
                    <li>页面编辑</li>
                    <li>布局管理</li>
                </ul>
                <div class="page-operation-btns">
                    <button type="button">备份</button>
                    <button type="button">预览</button>
                    <button type="button">发布站点</button>
                </div>
            </div>
            <div class="pc-page">
                <div class="page-container" style="width: 1226px;height: 215.2px;background-image: none;">
                    <div class="vl-container">
                        <iframe class="page-to-design" src="/page/canvas.html?pageId=${page.id}" frameborder="0"
                                style="height: 2661px;width: 1456px;display: block;"></iframe>
                    </div>
                    <div class="vl-design-mode-shim">

                    </div>
                    <bar class="selected-module-mask">

                    </bar>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
