package org.example.novelcommon.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.utils
 * @Project：my
 * @Date：21/11/2024 11:45 am
 */
public class DateUtil {
    public final String DATE_PATTERN ="yyyy-MM-dd";

    public final String DATE_TIME_PATTERN="yyyy-MM-dd HH:mm:ss";
    public static final String TIME_PATTERN = "HH:mm:ss";


    /**
     * 获取昨天的日期时间
     * */
    public static Date getYesterday(){
        Calendar instance = Calendar.getInstance();
        instance.add(5,-1);
        return instance.getTime();
    }
    /**
     * 根据日期，获取当天开始时间
     * */
    public static Date getDateStartTime(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        /*
         * Calendar.HOUR_OF_DAY:是指获取24小时制的小时,取值范围:0-23;
         * Calendar.HOUR:是指获取12小时制的小时,取值范围:0-12,凌晨和中午都是0,不是12;
         * 需要配合Calendar.AM_PM使用;
         * */
        gregorianCalendar.set(Calendar.HOUR_OF_DAY,0);
        gregorianCalendar.set(Calendar.HOUR,0);
        gregorianCalendar.set(Calendar.SECOND,0);
        gregorianCalendar.set(Calendar.MILLISECOND,0);
        return gregorianCalendar.getTime();
    }

    /**
     * 根据日期，获取当天结束时间
     * */
    public static Date getDateEndTime(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        /*
         * Calendar.HOUR_OF_DAY:是指获取24小时制的小时,取值范围:0-23;
         * Calendar.HOUR:是指获取12小时制的小时,取值范围:0-12,凌晨和中午都是0,不是12;
         * 需要配合Calendar.AM_PM使用;
         * */
        gregorianCalendar.set(Calendar.HOUR_OF_DAY,23);
        gregorianCalendar.set(Calendar.HOUR,59);
        gregorianCalendar.set(Calendar.SECOND,59);
        gregorianCalendar.set(Calendar.MILLISECOND,999);
        return gregorianCalendar.getTime();
    }
    /**
     * 获取上个月开始时间
     *
     * @return
     */
    public static Date getLastMonthStartTime(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR,0);
        instance.add(Calendar.MONTH,-1);
        instance.set(Calendar.DAY_OF_MONTH,1);
        instance.set(Calendar.HOUR_OF_DAY,0);
        instance.set(Calendar.MILLISECOND,0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        return instance.getTime();
    }
    /**
     * 获取上个月结束时间
     *
     * @return
     */
    public static Date getLastMonthEndTime(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR,0);
        instance.add(Calendar.MONTH,-1);
        instance.set(Calendar.DAY_OF_MONTH,instance.getActualMaximum(Calendar.DAY_OF_MONTH));
        instance.set(Calendar.HOUR_OF_DAY,23);
        instance.set(Calendar.MILLISECOND,999);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        return instance.getTime();
    }
    /**
     * 格式化日期
     * */
    public static String formatDate(Date date,String patten){
        return new SimpleDateFormat(patten).format(date);
    }

}
