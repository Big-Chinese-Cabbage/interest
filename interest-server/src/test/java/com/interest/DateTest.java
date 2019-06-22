package com.interest;

import com.interest.utils.DateUtil;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;

public class DateTest {

    @Test
    public void test1(){
        System.out.println(DateUtil.currentLocalDataTime());
    }

    @Test
    public void test2(){

        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.println(DateUtil.currentTimes());
    }

    @Test
    public void test3(){
        String time = "1554048000000";

        Instant instant = Instant.ofEpochMilli(Long.valueOf(time));
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId).with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
        System.out.println(localDateTime.atZone(zoneId).toInstant().toEpochMilli());

        //Timestamp timestamp= Timestamp.valueOf(LocalDateTime.now());
        long t1 = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).atZone(ZoneId.systemDefault()).toInstant()
                .toEpochMilli();
        long t2 = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        String t3 = DateUtil.firstDayOfMonth(DateUtil.currentTimestamp());
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0).atZone(ZoneId.systemDefault()).toInstant()
                .toEpochMilli());
    }

    @Test
    public void test4(){
        Instant instant = Instant.ofEpochMilli(Long.valueOf(1554048000000L));
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,zoneId).with(TemporalAdjusters.lastDayOfMonth()).withHour(0).withMinute(0).withSecond(0).withNano(0);
        System.out.println(localDateTime.atZone(zoneId).toInstant().toEpochMilli());
        System.out.println(DateUtil.lastDayOfMonth("1554131994680"));
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));
        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));
    }

    @Test
    public void test5(){
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
        System.out.println(DateUtil.firstDayOfWeek(String.valueOf(LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY)).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())));
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
        System.out.println(LocalDateTime.now().get(WeekFields.of(DayOfWeek.MONDAY,1).dayOfWeek()));
    }

    @Test
    public void test6(){
        String time = "1554306923235";
        System.out.println(time);
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(time)),ZoneId.systemDefault()));
        System.out.println(DateUtil.dayStart(time));
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(DateUtil.dayStart(time))),ZoneId.systemDefault()));
        System.out.println(DateUtil.dayEnd(time));
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(DateUtil.dayEnd(time))),ZoneId.systemDefault()));
    }

}
