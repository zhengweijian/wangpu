<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态数据类型</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form class="form form-horizontal">
        <div class="form-group">
            <label for="name" class="control-label col-md-2">类型名称</label>
            <div class="col-md-4">
                <input type="text" id="name" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="tag" class="control-label col-md-2">类型标签</label>
            <div class="col-md-4">
                <input type="text" id="tag" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="category" class="control-label col-md-2">类型名称</label>
            <div class="col-md-4">
                <select name="category" class="form-control" id="category">
                    <option value="1">基础数据类型</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">字段配置</label>
            <div class="col-md-10">
                <button class="btn btn-primary">新增字段</button>
                <div id="field-list" class="fieldList">
                    <div class="field">
                        <input type="text" value="文字" placeholder="字段名称">
                        <input type="text" value="NAME" placeholder="字段key">
                        <select>
                            <option value="">字段类型</option>
                            <option value="url">URL</option>
                            <option value="text">TEXTAREA</option>
                        </select>
                        <select><%--是否必须--%>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
