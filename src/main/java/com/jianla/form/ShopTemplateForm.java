package com.jianla.form;

/**
 * @author : zwj
 * @data : 2017/4/21
 */
public class ShopTemplateForm {

    private String name;//模板名称

    private String owner;//设计师

    private String deadLineTime;//到期时间

    private String price;//价格

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDeadLineTime() {
        return deadLineTime;
    }

    public void setDeadLineTime(String deadLineTime) {
        this.deadLineTime = deadLineTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
