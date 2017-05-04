<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模板管理中心</title>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>模板名称</th>
                <th>模板描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>默认首页模板</td>
                <td>用于首页的构建</td>
                <td>
                    <a href="/template/create.html?page=index">
                    <button class="btn btn-primary">创建页面</button>
                    </a>
                </td>
            </tr>
            <tr>
                <td>默认频道页模板</td>
                <td>用于频道页的构建</td>
                <td>
                    <a href="/template/create.html?page=default_markets">
                    <button class="btn btn-primary">创建页面</button>
                    </a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
