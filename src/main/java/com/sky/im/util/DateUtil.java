package com.sky.im.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getFormatSSS(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		String formatStr =formatter.format(date);
		return formatStr;
	}
	/**
     * 指定日期加上小时后的日期
     * @param num 为增加的天数
     * @param date 时间
     * @return
     * @throws ParseException 
     */
    public static Date plusHour(int num,Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.HOUR, num);// num为增加的小时，可以改变的
        return ca.getTime();
    }
	/**
     * 指定日期加上天数后的日期
     * @param num 为增加的天数
     * @param date 时间
     * @return
     * @throws ParseException 
     */
    public static Date plusDay(int num,Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        return ca.getTime();
    }
    /**
     * 指定日期加上多少分钟后的日期
     * @param num 为增加的分钟
     * @param date 时间
     * @return
     * @throws ParseException 
     */
    public static Date plusMinute(int num,Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MINUTE, num);
        return ca.getTime();
    }
    public static void main(String[] args) {
		Date date=new Date();
		System.out.println(getFormatSSS(date));
		date=plusHour(1,date);
		System.out.println(getFormatSSS(date));
	}
}
