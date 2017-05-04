$(function(){
    //删除按钮不拖动
    $('body').on('mousedown','.act-del',function(){
        return false;
    });

    function acceptSize(width,context){
        var supportWidths = context.split('-');
        console.log(supportWidths," match ",width);
        for(var i=0;i<supportWidths.length;i++){
            if(supportWidths[i]==width)
                return true;
        }
        return false;
    }

    function enterRegion($region,$module){
        // console.debug("enter region",$module,$region);
        var max = $region.parents('.J_TLayout').data('max');
        var len = $region.find('.J_TModule').length;
        // console.log(max,len);
        if(len>=max) return false;//该区域最多模块个数为max

        var width = $region.data('width');//区域接收尺寸
        var context = $module.data('context');//模块支持尺寸
        return acceptSize(width,context);
    }
    function enterModule($module){
        if($module.data('isadd')==1) return true;
        return false;
    }
    //模块组件可拖动新增（自身之间不可拖动）
    $('body').drag({
        source:'.J_NModule',
        placeholderClass:'empty-module tb-module',
        region:'.J_TRegion',
        module:'.J_TModule',
        enterRegion:enterRegion,
        enterModule:enterModule,
        onMouseUp:function ($module,$placeholder){
            var toLayoutId = $placeholder.parents('.J_TLayout').data('id');
            var toRegion = $placeholder.parents('.J_TRegion').data('modules');
            var toModuleLoc = $placeholder.prevAll('.J_TModule.tb-module').length;
            if(!toLayoutId || !toRegion) return false;
            var layout = toLayoutId+'-'+toRegion+'-'+toModuleLoc;
            var data = {
                layout : layout,//16364825073-sub-2
                module_comp_id:$module.data('modid'),
                pageId : $('#pageId').val()
            };
            // console.log($module,data);
            //post new module
            $.post('/module/newModule.json',data,function(data){
                if(typeof(data)!="object") data=JSON.parse(data);
                if(data && data.success){
                    vm.loadPage();
                }
            })
        }
    });
    //模块控件可拖动移动（clone是黑框）
    $('body').drag({
        source:'.J_TModule',
        placeholderClass:'empty-module tb-module',
        onMouseDown:function($module){
            // console.log($module,$module.data('ismove'));
            return $module.data('ismove')==1;
        },
        region:'.J_TRegion',
        module:'.J_TModule',
        enterRegion:enterRegion,
        enterModule:enterModule,
        onMouseUp:function ($module,$placeholder){
            //根据placeholder位置进行操作，算出
            //找到前面有几个"J_TModule"，parent的data-modules="sub"还是"main"
            //opt:move
            var fromLayoutId = $module.parents('.J_TLayout').data('id');
            var fromRegion = $module.parents('.J_TRegion').data('modules');
            var fromModuleLoc = $module.prevAll('.J_TModule.tb-module').length;
            var from = fromLayoutId+'-'+fromRegion+'-'+fromModuleLoc;

            var toLayoutId = $placeholder.parents('.J_TLayout').data('id');
            var toRegion = $placeholder.parents('.J_TRegion').data('modules');
            var toModuleLoc = $placeholder.prevAll('.J_TModule.tb-module').length;
            var to = toLayoutId+'-'+toRegion+'-'+toModuleLoc;
            var data = {
                pageId :$('#pageId').val(),
                from : from,//16364825073-sub-1
                to : to,//16364825073-sub-2
                moduleWidgetId : $module.data('id')//16387893196
            };
            $.post('/module/moveModule.json',data,function(data){
                if(typeof(data)!="object") data=JSON.parse(data);
                if(data && data.success){
                    vm.loadPage();
                }
            })
        }
    });
});

var vm = new Vue({
    el:'#page',
    data:{
        moduleInfoList:[],//模块列表
        page : {
            maxLayout:1,
            hd:[],
            bd:[],
            ft:[]
        },//页面布局信息
        bodyLayoutComp : []
    },
    methods:{
        loadPage : function(){
            var self = this;
            $.get('/page/getLayout.json?pageId='+$("#pageId").val(),function (data) {
                if(typeof(data)!="object") data=JSON.parse(data);
                if(data && data.success){
                    self.page = data.data;
                }
            });
        },
        loadModules:function (width) {
            var self = this;
            $.get('/module/getModules.json',{
                pageId:$('#pageId').val(),
                width:width
            },function (data) {
                if(typeof(data)!="object") data=JSON.parse(data);
                if(data && data.success){
                    self.moduleInfoList = data.moduleInfoList;
                }
            });
        },
        addLayout:function(){
            $('#addLayoutModal').modal('show');
        },
        doAddLayout:function(layoutCompId){
            var self = this;
            $.post('/layout/add.json',{
                pageId : $("#pageId").val(),
                layoutCompId:layoutCompId
            },function(data){
                if(typeof(data)!="object") data=JSON.parse(data);
                $('#addLayoutModal').modal('hide');
                if(data && data.success){
                    self.loadPage();
                }else{
                    alert(data.msg);
                }
            })
        },
        moveLayout:function (layout, direction) {
            var self = this;
            $.post('/layout/move.json',{
                pageId : $("#pageId").val(),
                layoutWidgetId:layout.layoutWidgetId,
                direction : direction
            },function(data){
                if(typeof(data)!="object") data=JSON.parse(data);
                if(data && data.success){
                    self.loadPage();
                }else{
                    alert(data.msg);
                }
            });
        },
        delLayout:function(layout){
            var self=this;
            if(confirm("删除布局会将布局内的模块一并删除，您确定要删除吗？")){
                $.post('/layout/del.json',{
                    pageId : $("#pageId").val(),
                    layoutWidgetId:layout.layoutWidgetId
                },function(data){
                    if(typeof(data)!="object") data=JSON.parse(data);
                    if(data && data.success){
                        self.loadPage();
                    }else{
                        alert(data.msg);
                    }
                })
            }
            return false;
        },
        delModule:function(module){
            // console.log('delete module')
            var self = this;
            if(confirm("是否确定删除模块“"+module.title+"”?")){
                $.post('/module/delModule.json',{
                    pageId:$('#pageId').val(),
                    moduleWidgetId:module.moduleWidgetId
                },function(data){
                    if(typeof(data)!="object") data=JSON.parse(data);
                    if(data && data.success){
                        self.loadPage();
                    }else{
                        alert(data.msg);
                    }
                });
            }
            return false;
        }
    },
    mounted:function () {
        var self = this;
        //加载页面
        this.loadPage();
        //初始加载模块
        this.loadModules();
        //初始新增布局
        $.get('/layout/getBodyLayout.json',function(data){
            if(typeof(data)!="object") data=JSON.parse(data);
            if(data && data.success){
                self.bodyLayoutComp = data.data;
            }
        })
    }
});