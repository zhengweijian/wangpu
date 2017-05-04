/**
 * 拖动js
 * 区域region属性
 * 1. active 是否可接受
 * 
 * 拖动对象module属性
 * 1. ismove
 * 2. isedit
 * 3. isdel
 */
(function($){
	"use strict";
	function Mouse(){//鼠标对象
		var self = this;
		this.x=0;
		this.y=0;
		this.target=false;//拖动对象
		this.clone=false;//拖动对象clone
		this.placeholder=false;
		this.cloneoffset = {x:0,y:0};
		this.move = function(e){
			self.x = e.pageX;
			self.y = e.pageY;
			if(self.clone !=false && self.target!=false){
				self.clone.css({
					top:self.y-self.cloneoffset.y,
					left:self.x-self.cloneoffset.x
				})
			}
		};
		$(window).on('mousemove',function(e){
			self.move(e);//实时更新鼠标坐标
		})
	}

	$.prototype.drag = function (opts) {//jquery对象增加原生方法
        var me, defaults, options;
        me = this;
        // console.log(this);
        defaults = {
            source : '>div',//拖动源
            region : '.J_TRegion',
            module : '.J_TModule',
            placeholder : 'drop here',//预览提示
            placeholderClass : 'placeholder-area',
            draggingClass:'dragging',//拖动对象类
            cloneClass: 'clone-area',//克隆拖动对象类
            onMouseDown : function(module){},//选择拖动，返回false不能拖动
            onMouseUp : function(module,placeholder){},//完成拖动
            enterRegion : function(region,module){return true},//进入放置区域
            enterModule : function (module) {return true}//进入模块
        };
        options = $.extend(defaults, opts);

        var mouse = new Mouse();

        var source = options.source;
        var region = options.region;
        var module = options.module;
        var placeholder = options.placeholder;
        var placeholderClass = options.placeholderClass;
        var draggingClass = options.draggingClass;
        var cloneClass = options.cloneClass;
        var onMouseDown = options.onMouseDown;
        var onMouseUp = options.onMouseUp;
        var enterRegion = options.enterRegion;
        var enterModule = options.enterModule;
        var active = false;//该区域是否可放置

        /**
         * 设置放置区域
         * @param {jquery选择器} [region] [可以放置区域的对象]
         * @param {jquery选择器} [module] [可放置的模块，移入有效]
         */
        $('body').on('mouseenter',region,function(){
            if (mouse.target != false && mouse.clone != false) {
                active = enterRegion($(this),mouse.target);
                // console.debug("mouse enter,active = ",active);
                if(active){
                    $('body').find('.emptyp').show();
                    $(this).find('.emptyp').hide();
                }
            }
        });

        /**
         * 点击拖动
         */
        $(this).each(function () {
            var $this = $(this);//module-list or regions
            // console.log("each--",$this);
            /**
             * 左键拖动初始化
             * 设置mouse的target、clone和placeholder
             */
            $('body').on('mousedown touchstart',source,function(e){
                // console.debug("mouse down and touch start...")
                
                if (mouse.target == false && e.which == 1) {//左键拖动

                    if(onMouseDown($(this))==false) return false;

                    active=true;
                    mouse.target = $(this);
                    //创建clone对象
                    mouse.clone = $("<div>").css({
                        'border': '2px solid gray',
                        'z-index': 2147483647,
                        'width': mouse.target.outerWidth(),
                        'height': mouse.target.outerHeight()
                    });
                    $('body').append(mouse.clone);
                    mouse.clone.addClass(cloneClass);
                    mouse.cloneoffset.x = mouse.x-mouse.target.offset().left;
                    mouse.cloneoffset.y = mouse.y-mouse.target.offset().top;
                    mouse.clone.css({
                        position: 'absolute',
                        top: mouse.y - mouse.cloneoffset.y,
                        left: mouse.x - mouse.cloneoffset.x
                    });
                    mouse.target.addClass(draggingClass);

                    //预览
                    mouse.placeholder = $('<div>drop here</div>');
                    mouse.placeholder.addClass(placeholderClass);

                    $('html,body').addClass('no-select');
                    // console.log("set mouse target",mouse);
                    return false;
                }
            });

        });

        /**
         * 移动鼠标，位置预览
         */
        $('body').on('mousemove',module, function () {//模块中移动
            var obj = $(this);
            //console.debug("mouse move obj ",obj,mouse.placeholder);
            if (mouse.target != false && mouse.clone != false && active!=false && enterModule($(this))) {
                var height = obj.outerHeight();
                var loc = mouse.y - obj.offset().top;
                if(loc<=height/2){//在obj的上方
                    obj.before(mouse.placeholder);
                }else{//在obj的下方
                    obj.after(mouse.placeholder);
                }
            }
        });

        //松开鼠标
        $(document).on('mouseup', function () {
            // console.debug("mouse up")
            if(mouse.target != false && mouse.clone != false) {
                // console.debug("handle onMouseUp")
                if(active==true){
                    onMouseUp(mouse.target,mouse.placeholder);
                }

                //恢复拖动前
                mouse.target.removeClass(draggingClass);
                mouse.target = false;

                mouse.clone.remove();
                mouse.clone = false;

                mouse.placeholder.remove();
                mouse.placeholder = false;
            }
            active=false;
            $('body').find('.emptyp').show();
        });

        return this;
	}
})(jQuery);