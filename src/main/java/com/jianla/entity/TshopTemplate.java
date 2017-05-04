package com.jianla.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 店铺模板
 *
 * @author : zwj
 * @data : 2017/4/20
 */
@Entity
@Table(name="tshop_template")
public class TshopTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private Long id;

    @Column(name="name")
    private String name;//模板名称

    @Column(name="owner")
    private String owner;//拥有者

    @Column(name="dead_line_time")
    private String deadLineTime;//截止时间

    @Column(name="price")
    private String price;//价格

    @Column(name="img_url")
    private String imgUrl;//展示图片

    @Column(name="create_time")
    private Date createTime;

    @Column(name="type")
    private Short type;//模板类型，1为官方，0为备份

    @Column(name="status")
    private Short status;//模板状态，1为发布，0为创建，-1为删除

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

}
