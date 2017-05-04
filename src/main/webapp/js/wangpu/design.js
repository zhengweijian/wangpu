var vm = new Vue({
    el:'#page',
    data:{
        themes : [],
    },
    methods:{
        changeSkin:function (skin) {
            console.log(skin);
        }
    },
    mounted:function(){
        var self = this;
        $.get('/template/skin/list.json?templateId='+$("#templateId").val(),function (data) {
            if(typeof(data)!="object") data=JSON.parse(data);
            if(data&&data.success){
                self.themes = data.data;
            }
        })
    }
});