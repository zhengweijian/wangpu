<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>默认频道页模板</title>
</head>
<body>
<div class="container">
    <button @click="addFloor">新建楼层</button>
    <div class="row" v-for="(floor,index) in floors">
        <div class="floor-operation">
            <span class="floor-delete" @click="removeFloor(floor,index)">x</span>
            <span class="floor-up" @click="floorUp(floor,index)">↑</span>
            <span class="floor-down" @click="floorDown(floor,index)">↓</span>
        </div>
        <div class="element-list">
            
        </div>
    </div>
</div>
<script src="/js/vue.min.js"></script>
<script>
var vm = new Vue({
    el:'.container',
    data:{
        floors:[],
    },
    methods:{
        addFloor:function(){
            this.floors.push({
                name:'新建楼层'
            });
        },
        removeFloor:function(floor,index){
            if(confirm("是否删除楼层"+floor.name)){
                this.floors.splice(index,1)
            }
        },
        floorUp:function(floor,index){
            if(index==0) return;
            var newFloors = this.floors;
            var tmp = newFloors[index-1];
            newFloors[index] = newFloors[index-1];
            newFloors[index-1] = tmp;
        },
        floorDown:function(floor,index){
            var newFloors = this.floors;
            if(index==newFloors.length-1) return;
            var tmp = newFloors[index+1];
            newFloors[index] = newFloors[index+1];
            newFloors[index+1] = tmp;
        }
    }
})
</script>
</body>
</html>
