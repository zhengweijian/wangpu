<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页面开始 -->
<div class="vl-layout-container">
    <div class="page-layout-edit" :data-max-layout="page.maxLayout" :data-max-module="page.maxModule">
        <!-- head -->
        <div class="layout-hd">
            <div v-for="layout in page.hd" class="layout J_TLayout" :class="layout.cssName"
                 :data-max="layout.maxModule" :data-id="layout.layoutWidgetId" :data-compid="layout.layoutCompId">
                <p class="title"><span>店铺页头</span></p>
                <div class="col-main">
                    <div class="main-wrap J_TRegion" data-modules="main" :data-width="layout.mainWidth">
                        <div v-for="module in layout.main" class="tb-module J_TModule"
                             :data-id="module.moduleWidgetId" :data-compid="module.moduleId" :data-context="module.context"
                             :data-isdel="module.isdel" :data-isedit="module.isedit" :data-ismove="module.ismove" :data-isadd="module.isadd">
                            <span>{{module.title}}</span>
                            <a href="#del" class="act-del" v-if="module.isdel" @click="delModule(module)"></a>
                        </div>
                        <div v-if="layout.main.length==0" class="J_TEmptyBox emptyp J_TModule" data-ismove="0" data-isadd="1">
                            <span>请拖入模块</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- body -->
        <div class="layout-bd">
            <div v-for="layout in page.bd" class="layout J_TLayout" :class="layout.cssName"
                 :data-max="layout.maxModule" :data-id="layout.layoutWidgetId" :data-compid="layout.layoutCompId">
                <p class="layout-cl">
                    <a class="move-up glyphicon glyphicon-arrow-up" @click="moveLayout(layout,'up')" title="上移"></a>
                    <a class="move-down glyphicon glyphicon-arrow-down" @click="moveLayout(layout,'down')" title="下移"></a>
                    <%--<a class="edit" title="编辑"></a>--%>
                    <a class="del glyphicon glyphicon-remove" @click="delLayout(layout)" title="删除"></a>
                </p>
                <div class="col-main">
                    <div class="main-wrap J_TRegion" data-modules="main" :data-width="layout.mainWidth">
                        <div v-for="module in layout.main" class="tb-module J_TModule"
                             :data-id="module.moduleWidgetId" :data-compid="module.moduleId" :data-context="module.context"
                             :data-isdel="module.isdel" :data-isedit="module.isedit" :data-ismove="module.ismove" :data-isadd="module.isadd">
                            <span>{{module.title}}</span>
                            <a href="#del" class="act-del" v-if="module.isdel" @click="delModule(module)"></a>
                        </div>
                        <div v-if="layout.main.length==0" class="J_TEmptyBox emptyp J_TModule" data-ismove="0" data-isadd="1">
                            <span>请拖入模块</span>
                        </div>
                    </div>
                </div>
                <%--如果sub存在--%>
                <div class="col-sub" v-if="layout.subWidth">
                    <%--循环layout--%>
                    <div class="main-wrap J_TRegion" data-modules="sub" :data-width="layout.subWidth">
                        <div v-for="module in layout.sub" class="tb-module J_TModule"
                             :data-id="module.moduleWidgetId" :data-compid="module.moduleId" :data-context="module.context"
                             :data-isdel="module.isdel" :data-isedit="module.isedit" :data-ismove="module.ismove" :data-isadd="module.isadd">
                            <span>{{module.title}}</span>
                            <a href="#del" class="act-del" v-if="module.isdel" @click="delModule(module)"></a>
                        </div>
                        <div v-if="layout.sub.length==0" class="J_TEmptyBox emptyp J_TModule" data-ismove="0" data-isadd="1">
                            <span>请拖入模块</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="new-layout" v-if="page.maxLayout>page.bd.length">
            <a href="#" @click="addLayout" class="add-layout">添加布局单元</a>
        </div>
        <!-- foot -->
        <div class="layout-ft">
            <div v-for="layout in page.ft" class="layout J_TLayout" :class="layout.cssName"
                 :data-max="layout.maxModule" :data-id="layout.layoutWidgetId" :data-compid="layout.layoutCompId">
                <div class="col-main">
                    <div class="main-wrap J_TRegion" data-modules="main" :data-width="layout.mainWidth">
                        <div v-for="module in layout.main" class="tb-module J_TModule"
                             :data-id="module.moduleWidgetId" :data-compid="module.moduleId" :data-context="module.context"
                             :data-isdel="module.isdel" :data-isedit="module.isedit" :data-ismove="module.ismove" :data-isadd="module.isadd">
                            <span>{{module.title}}</span>
                            <a href="#del" class="act-del" v-if="module.isdel" @click="delModule(module)"></a>
                        </div>
                        <div v-if="layout.main.length==0" class="J_TEmptyBox emptyp J_TModule" data-ismove="0" data-isadd="1">
                            <span>请拖入模块</span>
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
<!-- 页面结束 -->
