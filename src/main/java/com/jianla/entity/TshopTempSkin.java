package com.jianla.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : zwj
 * @data : 2017/4/21
 */
@Entity
@Table(name="tshop_template_skin")
public class TshopTempSkin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skin_id")
    private Long skinId;

    @Column(name="template_id")
    private Long templateId;

    @Column(name="skin_name")
    private String skinName;

    @Column(name="skin_color")
    private String skinColor;//rgb颜色 #

    @Column(name="skin_img_url")
    private String skinImgUrl;//配色图片

    @Column(name="css_paths")
    private String cssPaths;//css路径

    @Column(name="is_deleted")
    private Boolean deleted;//伪删除字段

    public Long getSkinId() {
        return skinId;
    }

    public void setSkinId(Long skinId) {
        this.skinId = skinId;
    }

    public String getSkinName() {
        return skinName;
    }

    public void setSkinName(String skinName) {
        this.skinName = skinName;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getSkinImgUrl() {
        return skinImgUrl;
    }

    public void setSkinImgUrl(String skinImgUrl) {
        this.skinImgUrl = skinImgUrl;
    }

    public String getCssPaths() {
        return cssPaths;
    }

    public void setCssPaths(String cssPaths) {
        this.cssPaths = cssPaths;
    }
}
