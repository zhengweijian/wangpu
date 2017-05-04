<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>功能测试列表</h2>
    <style>
        .func-item{
            width : 33%;
        }
        .func-item .title{
            font-size:16px;
        }
        .func-item ul{
            list-style: none;
        }
        .func-item ul li{
            line-height: 22px;
        }
        .func-item .ok{
            color:green;
        }
        .func-item .not-ok{
            color:red;
        }
    </style>
</head>
<body>

<div class="func-item">
    <a class="title" href="/admin/template/center.html">平台模板管理页面</a>
    <ul>
        <li class="ok">新增、修改模板</li>
        <li class="ok">增加、修改、删除模板配色</li>
        <li class="ok">图片预览上传</li>
        <li class="ok">配置模板初始化站点</li>
        <li class="ok">预定义的数据库数据有：布局组件、模块组件、id=1的site</li>
        <li class="ok">对site[id=1]的page进行初始装修，修改模块的move、del</li>
    </ul>
</div>
<div class="func-item">
    <a class="title" href="/page/layout.html?pageId=1">店铺装修-布局</a>
    <ul>
        <li class="ok">新增、移动、删除布局</li>
        <li class="ok">拖动新增模块、移动模块</li>
        <li class="ok">支持三个页面：旺铺首页、店内搜索页、服务详情页</li>
    </ul>
</div>
<div class="func-item">
    <a href="/page/design.html?pageId=1" class="title">店铺装修-设计</a>
    <ul>
        <li class="not-ok">对各个模块进行编辑</li>
        <li class="not-ok">配色</li>
        <li class="not-ok">页头</li>
        <li class="not-ok">页中</li>
        <li class="not-ok">css</li>
    </ul>
</div>
<div class="func-item">
    <a href="" class="title">方案1：机构选择模板即可</a>
    <ul>
        <li class="not-ok">机构选择预定义模板</li>
    </ul>
</div>
<div class="func-item">
    <a href="/template/manage.html" class="title">方案2：机构自定义装修</a>
    <ul>
        <li class="not-ok">开启旺铺</li>
        <li class="not-ok">应用模板生成站点</li>
        <li class="not-ok">模板备份、删除备份、应用备份</li>
        <li class="not-ok">预览页面</li>
        <li class="not-ok">发布站点</li>
    </ul>
</div>
<img src="/images/ER-pic.png" alt="数据库ER图">
</body>
</html>
