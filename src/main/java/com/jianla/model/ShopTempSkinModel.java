package com.jianla.model;

/**
 * 模板配色
 * @author : zwj
 * @data : 2017/4/21
 */
public class ShopTempSkinModel {

    private Long skinId;

    private Long templateId;

    private String skinName;

    private String skinColor;//rgb颜色 #

    private String skinImgUrl;//配色图片

    private String cssPaths;//css路径

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
