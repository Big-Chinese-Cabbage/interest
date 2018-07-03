package com.interest.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 当前系统时间戳
	 * @return
	 */
	public static String currentTimestamp() {
		return String.valueOf(new Date().getTime());
	}
	
	/**
	 * 当前系统时间（yyyyMMdd）
	 * @return
	 */
	public static String currentTimes() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		
		return format.format(new Date());
	}
	
	/**
	 * 月初时间戳
	 * @param time
	 * @return
	 */
	public static String monthFirstday(String time) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(new Date(Long.valueOf(time)));
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);  
        cale.set(Calendar.MINUTE, 0);  
        cale.set(Calendar.SECOND, 0);
        return String.valueOf(cale.getTimeInMillis());
	}
	
	/**
	 * 月末时间戳
	 * @param time
	 * @return
	 */
	public static String monthLastday(String time) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(new Date(Long.valueOf(time)));
		cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.set(Calendar.HOUR_OF_DAY, 23);  
        cale.set(Calendar.MINUTE, 59);  
        cale.set(Calendar.SECOND, 59);
        return String.valueOf(cale.getTimeInMillis());
	}
	
	/**
	 * 这天的开始
	 * @param time
	 * @return
	 */
	public static String daystart(String time) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(new Date(Long.valueOf(time)));
		cale.set(Calendar.HOUR_OF_DAY, 0);  
        cale.set(Calendar.MINUTE, 0);  
        cale.set(Calendar.SECOND, 0);
        return String.valueOf(cale.getTimeInMillis());
	}
	
	/**
	 * 这天的结束
	 * @param time
	 * @return
	 */
	public static String dayend(String time) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(new Date(Long.valueOf(time)));
		cale.set(Calendar.HOUR_OF_DAY, 23);  
        cale.set(Calendar.MINUTE, 59);  
        cale.set(Calendar.SECOND, 59);
        return String.valueOf(cale.getTimeInMillis());
	}
	
}
