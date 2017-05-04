package com.jianla.model;


import java.util.regex.Pattern;

/**
 * @author : zwj
 * @data : 2017/4/28
 */
public class LayoutLocation {

    private Long layoutWidgetId;

    private String slide;//main or sub

    private Integer index;//0

    public LayoutLocation(String layoutLocation) {
        String regex = "^(\\d)+-(sub|main)-(\\d)+$";
        Pattern pattern = Pattern.compile(regex);
        boolean matches = pattern.matcher(layoutLocation).matches();
        if(!matches) {
            throw new IllegalArgumentException("Error Format.示例格式为 123-main-3，998-sub-0。");
        }

        String[] strings = layoutLocation.split("-");
        this.layoutWidgetId = Long.parseLong(strings[0]);
        this.slide = strings[1];
        this.index = Integer.parseInt(strings[2]);
    }

    public static void main(String[] args) {
        String iLoveU  = "I Love U";
        for (String str : iLoveU.split("[^A-Za-z]")) {//匹配到所有非字母则进行分割
            System.out.println(str);
        }

        LayoutLocation layoutLocation = new LayoutLocation("16390613688-sub-0");
        System.out.println(layoutLocation);
    }

    public Long getLayoutWidgetId() {
        return layoutWidgetId;
    }

    public void setLayoutWidgetId(Long layoutWidgetId) {
        this.layoutWidgetId = layoutWidgetId;
    }

    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LayoutLocation{");
        sb.append("layoutWidgetId=").append(layoutWidgetId);
        sb.append(", slide='").append(slide).append('\'');
        sb.append(", index=").append(index);
        sb.append('}');
        return sb.toString();
    }
}
