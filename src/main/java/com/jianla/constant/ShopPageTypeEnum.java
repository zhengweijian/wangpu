package com.jianla.constant;

/**
 * @author : zwj
 * @data : 2017/4/28
 */
public enum  ShopPageTypeEnum {

    INDEX("旺铺首页",(short)1),

    SEARCH("店内搜索页",(short)2),

    DETAIL("服务详情页",(short)3),

    //CUSTOM("自定义页",(short)4),

    //宝贝分类页 5
    ;

    private final String name;

    private final Short value;

    ShopPageTypeEnum(String name, Short value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Short getValue() {
        return value;
    }

}
