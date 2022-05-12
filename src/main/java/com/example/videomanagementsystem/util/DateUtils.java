package com.example.videomanagementsystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {


    /**
     * ⽇期转换成字符串
     *
     * @param date
     * @return str
     */
    public static String DateToStr(Date date, String fmt) {
        SimpleDateFormat format = new SimpleDateFormat(fmt, Locale.CHINESE);
        return format.format(date);
    }

    /**
     * 字符串转换成⽇期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str, String fmt) {
        SimpleDateFormat format = new SimpleDateFormat(fmt, Locale.CHINESE);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String timeStampToDate(Long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        return formatter.format(new Date(time));
    }
}
