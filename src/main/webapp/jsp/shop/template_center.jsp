<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模板中心</title>
    <%--bootstrap--%>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <%--jquery.colpick--%>
    <link rel="stylesheet" href="/css/colpick.css">
    <script src="/js/colpick.js"></script>
    <%--bootstrap validate--%>
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css">
    <script src="https://cdn.bootcss.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery.bootstrapvalidator/0.5.3/js/language/zh_CN.min.js"></script>
    <style>
        [v-cloak] {
            display: none;
        }
        .skin-list ul{
            list-style-type: none;
            padding-left:0px;
        }
        .skin-list li{
            display: inline-block;
            margin:5px;
            cursor: pointer;
        }
        .skin-list .skin-block{
            width:15px;
            height:15px;
            display:block;;
        }
        .color-box {
            float:left;
            width:30px;
            height:30px;
            margin:5px;
            border: 1px solid white;
        }
        .display-img{
            max-height: 450px;
            max-width: 300px;
        }
    </style>
</head>
<body>
<div class="container" id="main">
    <button @click="add" class="btn btn-primary btn-sm">新增模板</button>
    <table class="table" v-cloak="">
        <thead>
        <tr>
            <th>模板名称</th>
            <th>设计师</th>
            <th>价格</th>
            <th>到期时间</th>
            <th>展示图片</th>
            <th>初始化站点</th>
            <th>模板配色</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="temp in tempList">
            <td>{{temp.name}}</td>
            <td>{{temp.owner}}</td>
            <td>{{temp.price}}</td>
            <td>{{temp.deadLineTime}}</td>
            <td>
                <span v-if="temp.imgUrl" class="badge">已上传</span>
                <a href="#" @click.prevent="uploadImg(temp)">上传</a>
            </td>
            <td>
                <template v-if="temp.status==0">
                    <span v-if="temp.initSiteId" class="badge">已配置</span>
                    <span v-if="temp.initSiteId==null" class="badge">未配置</span>
                    <a href="#" @click.prevent="initSite(temp)" v-if="temp.status==0">配置页面</a>
                </template>
                <template v-if="temp.status==1">
                    <span class="badge">已发布</span>
                </template>
            </td>
            <td>
                <div class="skin-list">
                <ul>
                    <li v-for="skin in temp.skinList">
                        <a :title="skin.skinName" @click="updateSkin(skin)">
                            <span class="skin-block" :style="{background:skin.skinColor}"></span>
                        </a>
                    </li>
                </ul>

                </div>
            </td>
            <td>
                <template v-if="temp.status==1">
                    <button @click="doUnRelease(temp)" class="btn btn-danger btn-xs">下架</button>
                </template>
                <template v-if="temp.status==0">
                    <button @click="update(temp)" class="btn btn-warning btn-xs">修改</button>
                    <button @click="addSkin(temp)" class="btn btn-info btn-xs">增加配色</button>
                    <button @click="doRelease(temp)" class="btn btn-danger btn-xs">发布</button>
                </template>
            </td>
        </tr>
        </tbody>
    </table>

    <div id="templateModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">模板编辑</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="name" class="control-label col-md-3">模板名称</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="name" v-model="temp.name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="owner" class="control-label col-md-3">设计师</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="owner" v-model="temp.owner" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deadLineTime" class="control-label col-md-3">到期时间</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="deadLineTime" v-model="temp.deadLineTime" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="price" class="control-label col-md-3">模板价格</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="price" v-model="temp.price" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-3">
                                <button type="button" class="btn btn-primary" @click="doAdd" v-if="temp.id==null">新增</button>
                                <button type="button" class="btn btn-primary" @click="doUpdate" v-if="temp.id!=null">修改</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div id="tempSkinModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">配色编辑</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="skinForm">
                        <div class="form-group">
                            <label for="skinName" class="control-label col-md-3">配色名称</label>
                            <div class="col-md-6">
                                <input type="text" name="skinName"
                                       class="form-control" id="skinName" v-model="skin.skinName" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="skinColor" class="control-label col-md-3">颜色</label>
                            <div class="col-md-1">
                                <div class="color-box" id="skinColor" :style="{background:skin.skinColor}"></div>
                            </div>
                            <div class="col-md-5">
                                <div id="color-picker"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cssPaths" class="control-label col-md-3">css资源链接</label>
                            <div id="cssPaths" class="col-md-8">
                                <input type="text" name="cssPaths"
                                       class="form-control" v-model="skin.cssPaths">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-3">
                                <button type="button" class="btn btn-primary" @click="doAddSkin" v-if="skin.skinId==null">新增</button>
                                <button type="button" class="btn btn-primary" @click="doUpdateSkin" v-if="skin.skinId!=null">修改</button>
                                <button type="button" class="btn btn-danger" @click="doDeleteSkin" v-if="skin.skinId!=null">删除</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div id="tempImgModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">图片上传</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-12" style="text-align: center;">
                                <img :src="tempImg.imgUrl" class="display-img" alt="展示图片">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="imgUrl" class="control-label col-md-2">图片路径</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="imgUrl" v-model="tempImg.imgUrl" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8 col-md-offset-2">
                                <button type="button" class="btn btn-primary" @click="doUploadImg">上传</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>

<script src="/js/vue.js"></script>
<script>
$(function(){
    $("#skinForm").bootstrapValidator({
        fields:{
            skinName:{
                validators:{
                    notEmpty:{
                        message:"配色名称不能为空"
                    }
                }
            },
            cssPaths:{
                validators:{
                    notEmpty:{
                        message:"css资源路径不能为空"
                    }
                }
            }
        }
    });
})
var vm = new Vue({
    el:'#main',
    data:{
        tempList:[],
        temp:{},
        skin:{},
        tempImg:{}
    },
    methods:{
        add:function(){
            this.temp = {};
            $("#templateModal").modal('show');
        },
        doAdd:function(){
            var self = this;
            $.post('/admin/template/add.json',this.temp,function(data){
                if(typeof(data)!="object") data=JSON.parse(data);
                if(data && data.success){
                    $("#templateModal").modal('hide');
                    self.findPage();
                }
            });
        },
        update:function(temp){
            this.temp = temp;
            $("#templateModal").modal('show');
        },
        doUpdate:function(){
            var self = this;
            $.post('/admin/template/update.json',this.temp,function(data){
                if(typeof(data)!="object") data=JSON.parse(data);
                if(data && data.success){
                    $("#templateModal").modal('hide');
                    self.findPage();
                }
            });
        },
        doUnRelease:function (temp) {
            if(confirm("是否下架模板“"+temp.name+"”？")){
                $.post('/admin/template/unRelease.json',{templateId:temp.id},function (data) {
                    if(typeof(data)!="object") data=JSON.parse(data);
                    if(data && data.success){
                        self.findPage();
                    }
                })
            }
        },
        doRelease:function(temp){
            if(confirm("是否发布模板“"+temp.name+"”？")){
                $.post('/admin/template/release.json',{templateId:temp.id},function (data) {
                    if(typeof(data)!="object") data=JSON.parse(data);
                    if(data && data.success){
                        self.findPage();
                    }else{
                        alert(data.msg);
                    }
                })
            }
        },
        findPage:function(){
            var self = this;
            $.get("/admin/template/all.json",function (data) {
                if(typeof(data)!="object") data = JSON.parse(data);
                if(data && data.success){
                    self.tempList = data.data;
                }
            });
        },
        uploadImg:function (temp) {//上传
            this.tempImg = {
                templateId:temp.id,
                imgUrl:temp.imgUrl
            };
            $('#tempImgModal').modal('show');
        },
        doUploadImg:function(){
            var self = this;
            $.post('/admin/template/uploadImg.json',this.tempImg,function(data){
               if(typeof(data)!="object") data = JSON.parse(data);
               if(data && data.success){
                   self.findPage();
                   $("#tempImgModal").modal('hide');
               }
            });
        },
        addSkin:function(temp){
            this.skin = {skinColor:'#000',templateId:temp.id};
            $("#tempSkinModal").modal('show');
        },
        doAddSkin:function(){
            var validator = $("#skinForm").data('bootstrapValidator');
            validator.validate();
            if(!validator.isValid()){
                return false;
            }
            var self = this;
            $.post('/admin/tempSkin/add.json',this.skin,function(data){
                if(typeof(data)!="object") data = JSON.parse(data);
                if(data && data.success){
                    self.findPage();
                    $("#tempSkinModal").modal('hide');
                }
            });
        },
        updateSkin:function(skin){
            this.skin = skin;
            $("#tempSkinModal").modal('show');
        },
        doUpdateSkin:function(){
            var validator = $("#skinForm").data('bootstrapValidator');
            validator.validate();
            if(!validator.isValid()){
                return false;
            }
            var self = this;
            $.post('/admin/tempSkin/update.json',this.skin,function(data){
                if(typeof(data)!="object") data = JSON.parse(data);
                if(data && data.success){
                    self.findPage();
                    $("#tempSkinModal").modal('hide');
                }
            });
        },
        doDeleteSkin:function(){
            var skin = this.skin;
            if(confirm("是否删除配色“"+skin.skinName+"”？")){
                var self = this;
                $.post('/admin/tempSkin/delete.json',{"skinId":skin.skinId},function(data){
                    if(typeof(data)!="object") data = JSON.parse(data);
                    if(data && data.success){
                        self.findPage();
                        $("#tempSkinModal").modal('hide');
                    }
                });
            }
        },
        initSite:function (temp) {
            $.post('/admin/template/init_site.json',{templateId:temp.id},function(data){
                if(typeof(data)!="object") data = JSON.parse(data);
                if(data && data.success){
                    var url = '/page/layout.html?pageId='+data.pageId;
                    window.open(url);
                }else{
                    alert(data.msg);
                }
            });
        }
    },
    mounted:function(){
        var self =this;
        $('#color-picker').colpick({
            flat:true,
            layout:'rgbhex',
            color:'ff8800',
            onSubmit:function(hsb,hex,rgb,el) {
                $(el).css('background-color', '#'+hex);
                self.skin.skinColor = '#'+hex;
            }
        });
        this.findPage();
    }
})
</script>
</body>
</html>
