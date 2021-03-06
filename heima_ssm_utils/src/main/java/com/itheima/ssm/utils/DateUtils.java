package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换成字符串
    public static String date2String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
//        fomat 格式化
        String format = sdf.format(date);
        return format;
    }

    //字符串转换成日期
    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
//       parse  解析，分析
        Date parse = sdf.parse(str);
        return parse;
    }
    
    public static void main(String[] args){
    	DateUtils utils = new DateUtils();
    	Date date = new Date();
    	String dateStr = utils.date2String(date, "yyyy-MM-dd HH:mm:ss");
    	System.out.println(dateStr);
    }
}
