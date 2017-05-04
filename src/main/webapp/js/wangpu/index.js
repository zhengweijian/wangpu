$(function(){
	var slideWidth = 232;
	//窗口大小改变
	$(window).resize(function(e){
		var height = document.body.clientHeight;
		var width = document.body.clientWidth;
		var newWidth =  width-slideWidth-80+"px";
		$('.design-navigation-wrap').css({
			width:newWidth
		})
		$('.page-container').css({
			width:newWidth,
			height:height-117+"px"
		})
		$('.module-list').css({
			height: height-176+"px"
		})
		console.log("浏览器大小改变",width,height);
	});
	$(window).resize();

	$('.close-icon').click(function(){
		$(this).parent().removeClass('selected');
		$('.J_ToolbarItem').removeClass('selected');
		$('.main-wrapper-design-mode').removeClass('wpst-toolbar-show');
		slideWidth  = 0;
		$(window).resize();
	});
	//工具条子框选择
	$('.J_ToolbarItem').click(function(){
		if($(this).hasClass('disabled')){
			return false;
		}else if($(this).hasClass('selected')){//取消选择
			$(this).removeClass('selected');
			$('.toolbar .slide').removeClass('selected');
			$('.main-wrapper-design-mode').removeClass('wpst-toolbar-show');
			slideWidth  = 0;
			$(window).resize();
		}else{//选择
			$('.J_ToolbarItem').removeClass('selected');
			$('.toolbar .slide').removeClass('selected');
			
			$(this).addClass('selected');
			var slideName = $(this).data('slide');
			$('.toolbar .'+slideName+'-slide').addClass('selected');
			if(!$('.main-wrapper-design-mode').hasClass('wpst-toolbar-show')){
				$('.main-wrapper-design-mode').addClass('wpst-toolbar-show');
				slideWidth  = 232;
				$(window).resize();
			}
		}
	});
	//模块组件尺寸选择
	$('.J_SizeSelect').click(function(){
		$('.J_SizeSelect').removeClass('size-selected');
		$(this).addClass('size-selected');
		var width = $(this).data('size');
		vm.loadModules(width);
	});

	//模块hover
	$('body').on('mouseover mouseout','.J_TModule',function(event){
        if(event.type == "mouseover"){
            $(this).addClass('hover');
        }else if(event.type == "mouseout"){
            $(this).removeClass('hover');
        }
	});

	$('#selectPageType').change(function(){
		location=$(this).val();
	});

	//备份表单验证
	$('#backupModal').bootstrapValidator({
		message:'请检查字段',
		fields:{
			backupName:{
				validators:{
					notEmpty:{
						message:"不能为空"
					},
					stringLength:{
						max:10,
						message:"长度必须小于10个字符"
					}
				}
			},
			backupDesc:{
				validators:{
					stringLength:{
						max:50,
						message:"长度必须小于50个字符"
					}
				}
			}
		}
	}).on('success.form.bv', function(e) {//点击提交之后
		e.preventDefault();
		var $form = $(e.target);
		var bv = $form.data('bootstrapValidator');

		$.post('/backup/add.json', $form.serialize(), function (data) {
			if(typeof(data)!="object") data=JSON.parse(data);
			if(data && data.success){
				$('#backupModal').modal('hide');
				alert("备份成功");
			}else{
				alert(data.msg);
			}
		});
	});

});