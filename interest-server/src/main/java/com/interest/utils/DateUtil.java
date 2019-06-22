package com.interest.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 当前系统时间戳
	 * @return
	 */
	public static String currentTimestamp() {
		return String.valueOf(Instant.now().toEpochMilli());
	}
	
	/**
	 * 当前系统时间（yyyyMMdd）
	 * @return
	 */
	public static String currentTimes() {
		
		return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	/**
	 * 当前系统时间（yyyy-MM-dd: HH:mm:ss sss）
	 * @return
	 */
	public static String currentLocalDataTime(){
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd: HH:mm:ss SSS"));
	}
	
	/**
	 * 月初时间戳
	 * @param time
	 * @return
	 */
	public static String firstDayOfMonth(String time) {
		Instant instant = Instant.ofEpochMilli(Long.valueOf(time));
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId).with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
		return String.valueOf(localDateTime.atZone(zoneId).toInstant().toEpochMilli());
	}
	
	/**
	 * 月末时间戳
	 * @param time
	 * @return
	 */
	public static String lastDayOfMonth(String time) {
		Instant instant = Instant.ofEpochMilli(Long.valueOf(time));
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId).with(TemporalAdjusters.lastDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
		return String.valueOf(localDateTime.atZone(zoneId).toInstant().toEpochMilli());
	}

	/**
	 * 周一时间戳
	 * @param time
	 * @return
	 */
	public static String firstDayOfWeek(String time) {
		Instant instant = Instant.ofEpochMilli(Long.valueOf(time));
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId).withHour(0).withMinute(0).withSecond(0).withNano(0);
		if(localDateTime.getDayOfWeek().getValue() == 1){
			return String.valueOf(localDateTime.atZone(zoneId).toInstant().toEpochMilli());
		}else {
			return String.valueOf(localDateTime.atZone(zoneId).with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).toInstant().toEpochMilli());
		}
	}

	/**
	 * 这天的开始
	 * @param time
	 * @return
	 */
	public static String dayStart(String time) {
		Instant instant = Instant.ofEpochMilli(Long.valueOf(time));
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId).withHour(0).withMinute(0).withSecond(0).withNano(0);
		return String.valueOf(localDateTime.atZone(zoneId).toInstant().toEpochMilli());
	}
	
	/**
	 * 这天的结束
	 * @param time
	 * @return
	 */
	public static String dayEnd(String time) {
		Instant instant = Instant.ofEpochMilli(Long.valueOf(time));
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId).with(TemporalAdjusters.firstDayOfMonth()).withHour(23).withMinute(59).withSecond(59).withNano(999);
		return String.valueOf(localDateTime.atZone(zoneId).toInstant().toEpochMilli());
	}
	
}
