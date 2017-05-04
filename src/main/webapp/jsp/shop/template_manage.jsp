<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模板管理</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" id="main">
    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active">
                <a href="#home" aria-controls="home" role="tab" data-toggle="tab">可用的模板</a>
            </li>
            <li role="presentation">
                <a href="#backup" aria-controls="backup" role="tab" data-toggle="tab">备份的模板</a>
            </li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                <ul>
                    <li v-for="temp in tempList">
                        <a @click="showDetail(temp)">
                            <img :src="temp.imgUrl" :alt="temp.name">
                            <span class="click-info">点击查看图片详情及操作</span>
                        </a>
                        <p>价格：{{temp.price}}</p>
                        <p>设计师：{{temp.owner}}</p>
                        <p>{{temp.name}}</p>
                        <p>到期时间：<span class="highlight">{{temp.deadLineTime}}</span></p>
                        <p>
                            <a v-if="temp.inUse" class="btn" disabled="" href="#">正在使用</a>
                            <a v-else class="btn btn-default" href="#">马上使用</a>
                        </p>
                    </li>
                </ul>
            </div>
            <div role="tabpanel" class="tab-pane" id="backup">

            </div>
        </div>

    </div>

    <div id="templateModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">模板详情</h4>
                </div>
                <div class="modal-body">
                    <div class="tpl-image">
                        <img :src="temp.imgUrl" :alt="temp.name">
                    </div>
                    <div class="tpl-sku">
                        <h3>{{temp.name}}</h3>
                        <ul>
                            <li>模板类型：<span v-if="temp.type==1">官方模板</span>
                            </li>
                            <li class="color-list">
                                可选配色：
                                <a href="javascript:void(0)" :alt="skin.skinName" v-for="skin in temp.skins">
                                    <%--<img :src="skin.skinImgUrl" alt="">--%>
                                    <span :style="'color:'+skin.skinColor"></span>
                                </a>
                            </li>
                            <li>设计师：{{temp.owner}}</li>
                            <li>到期时间：<span class="highlight">{{temp.deadLineTime}}</span></li>
                            <li>模板价格：<span class="highlight">{{temp.price}}</span></li>
                        </ul>
                    </div>
                    <div class="sku-opt">
                        <a v-if="!temp.inUse" class="btn btn-default" href="#">应用</a>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div id="tempBackModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body">
                    <p>One fine body&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>


<script src="/js/vue.min.js"></script>
<script>
var vm = new Vue({
    el:'#main',
    data:{
        tempList:[],
        tempBackList:[],
        temp:{},
        tempBack:{}
    },
    methods:{
        showDetail:function(temp){
            this.temp = temp;
            $("#templateModal").modal('show');
        },
        shoBackDetai:function(tempBack){
            this.tempBack = tempBack;
            $("#tempBackModal").modal('show');
        }
    },
    mounted:function(){
        var self = this;
        $.get("/template/list.json",function (data) {
            if(typeof(data)!="object") data = JSON.parse(data);
            if(data && data.success){
                self.tempList = data.data;
            }
        });

        $.get("/tempBack/list.json",function (data) {
            if(typeof(data)!="object") data = JSON.parse(data);
            if(data && data.success){
                self.tempBackList = data.data;
            }
        });
    }
});
</script>
</body>
</html>
