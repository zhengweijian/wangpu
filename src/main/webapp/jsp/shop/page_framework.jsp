<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib_includes.jsp"%>
<html>
<head>
    <c:if test="${op=='layout'}"><c:set var="layout" value="true"/></c:if>
    <c:if test="${op=='design'}"><c:set var="layout" value="false"/></c:if>

    <c:if test="${layout}">
        <title>店铺装修-布局管理</title>
    </c:if>
    <c:if test="${!layout}">
        <title>店铺装修</title>
    </c:if>

    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrapValidator.css"/>
    <script type="text/javascript" src="/js/bootstrapValidator.js"></script>

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
                <%--<li><a href="/page/manage.html">页面管理</a></li>--%>
                <li><a href="/template/manage.html">模板管理</a></li>
            </ul>
        </div>
    </div>
    <div class="main-wrapper main-wrapper-design-mode wpst-toolbar-show">
        <%--左侧--%>
        <div class="vl-sidebar">
            <!-- 工具条 -->
            <ul class="tab-bar">
                <c:if test="${layout}"><c:set var="modulesClass" value="selected"/> </c:if>
                <c:if test="${!layout}"><c:set var="modulesClass" value="disabled"/></c:if>
                <li class="modules J_ToolbarItem ${modulesClass}" data-slide="modules">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon-th-large"></b>
                        <div class="">模块</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <c:if test="${layout}"><c:set var="themeClass" value="disabled"/></c:if>
                <c:if test="${!layout}"><c:set var="themeClass" value="selected"/></c:if>
                <li class="theme J_ToolbarItem ${themeClass}" data-slide="theme">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon glyphicon-film"></b>
                        <div class="">配色</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <li class="page-head J_ToolbarItem <c:if test="${layout}">disabled</c:if>" data-slide="page-head">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon-align-justify"></b>
                        <div class="">页头</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <li class="page J_ToolbarItem <c:if test="${layout}">disabled</c:if>" data-slide="page">
                    <div class="wrap">
                        <div class="left-line"></div>
                        <b class="item-icon glyphicon glyphicon-list-alt"></b>
                        <div class="">页面</div>
                        <b class="right-icon glyphicon glyphicon-triangle-left"></b>
                    </div>
                </li>
                <li class="css J_ToolbarItem <c:if test="${op=='layout'}">disabled</c:if>" data-slide="css">
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
                <c:if test="${layout}">
                <li class="slide modules-slide ${modulesClass}">
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
                            <%--模块列表--%>
                            <ul class="module-list">
                                <li v-for="module in moduleInfoList" class="J_NModule"
                                    :data-modid="module.moduleId" :data-max-append="module.maxAppend" :data-context="module.supportWidth">
									<span class="pic">
										<img :src="module.icon" :alt="module.tips">
									</span>
                                    <span :title="module.name" class="content">{{module.name}}</span>
                                </li>
                            </ul>

                        </div>
                    </div>
                </li>
                </c:if>
                <c:if test="${!layout}">
                <li class="slide theme-slide ${themeClass}">
                    <b class="glyphicon glyphicon-remove close-icon"></b>
                    <div class="inside">
                        <p>当前模板可以选择的配色方案</p>
                        <p class="gray">修改将应用所有页面</p>
                    </div>
                    <div class="color-snips">
                        <ul>
                            <li v-for="skin in themes" @click="changeSkin(skin)">
                                <a href="#" :title="skin.skinName"><span class="color-snip" :style="{background:skin.skinColor}"></span></a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="slide page-head-slide">页头配置（应用到所有页面、重置当前页）</li>
                <li class="slide page-slide">页面配置（应用到所有页面、重置当前页）</li>
                <li class="slide css-slide">css配置（需要订购才能使用
                    {message: "操作失败,你没有权限使用完全自定义Css功能"}）
                </li>
                </c:if>
            </ul>
        </div>
        <%--右侧--%>
        <div class="vl-main">
            <div class="design-navigation-wrap">
                <div class="design-page-select">
                    <select id="selectPageType" class="form-control input-sm">
                        <c:forEach var="sitePage" items="${sitePages}">
                            <option <c:if test="${page.id==sitePage.id}">selected="selected"</c:if>
                                value="/page/${op}.html?pageId=${sitePage.id}">${sitePage.pageName}</option>
                        </c:forEach>
                    </select>
                </div>
                <ul class="design-mode-select btn-group">
                    <li <c:if test="${op=='design'}">class="selected"</c:if>>
                        <a href="/page/design.html?pageId=${page.id}" class="btn btn-default btn-sm">页面编辑</a></li>
                    <li <c:if test="${op=='layout'}">class="selected"</c:if>>
                        <a href="/page/layout.html?pageId=${page.id}" class="btn btn-default btn-sm">布局管理</a></li>
                </ul>
                <div class="page-operation-btns">
                    <a href="#" class="btn btn-default btn-sm" data-toggle="modal" data-target="#backupModal">备份</a>
                    <a href="#" class="btn btn-default btn-sm">预览</a>
                    <a href="#" class="btn btn-default btn-sm">发布站点</a>
                </div>
            </div>
            <div class="page-container">
                <div class="vl-container">
                    <c:if test="${op=='layout'}">
                        <%@include file="page_layout.jsp"%>
                    </c:if>
                    <c:if test="${op=='design'}">
                        <iframe class="page-to-design" src="/page/canvas.html?pageId=" frameborder="0" style="height: 2661px;width: 1456px;display: block;">
                        </iframe>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${op=='layout'}">
    <%--增加布局--%>
    <div id="addLayoutModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">布局管理</h4>
                </div>
                <div class="modal-body">
                    <div class="add-layout-list">
                        <div v-for="layout in bodyLayoutComp" style="display: inline-block">
                            <a href="#" :class="layout.cssName" @click="doAddLayout(layout.layoutCompId)"></a>
                        </div>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    </c:if>
</div>
<input type="hidden" id="pageId" value="${page.id}">
<input type="hidden" id="templateId" value="${page.siteInstanceId}">

<%--增加备份--%>
<div id="backupModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">备份</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="backupName" class="control-label col-md-2">备份名</label>
                        <div class="col-md-4">
                            <input type="text" id="backupName" class="form-control" placeholder="10个汉字或字符" name="backupName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="backupDesc" class="control-label col-md-2">备注</label>
                        <div class="col-md-8">
                            <input type="text" id="backupDesc" class="form-control" placeholder="50个汉字或字符" name="backupDesc">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-6">
                            <button type="submit" class="btn btn-primary">确定</button>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="/js/wangpu/jquery.module-drag.js"></script>
<script src="/js/wangpu/index.js"></script>
<script src="/js/vue.js"></script>
<c:if test="${op=='layout'}">
    <script src="/js/wangpu/layout.js"></script>
</c:if>
<c:if test="${op=='design'}">
    <script src="/js/wangpu/design.js"></script>
</c:if>
</body>
</html>
