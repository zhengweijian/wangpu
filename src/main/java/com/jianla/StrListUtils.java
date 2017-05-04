package com.jianla;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/4/22
 */
public class StrListUtils {

    public static List<String> parse2List(String listStr){
        String[] strArr = listStr.split(",");
        List<String> list = new ArrayList<>();
        for (String str : strArr) {
            list.add(str);
        }
        return list;
    }

    public static String parse2Str(List<String> strList){
        if(strList==null || strList.size()==0) return "";
        StringBuffer sb = new StringBuffer();
        for (String str : strList) {
            sb.append(str).append(',');
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
