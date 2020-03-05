package com.peilw.child.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class TemporalAdjusterDemo {
    public static void main(String[] args){
        LocalDate date=LocalDate.now();
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
                temporal -> {
                    DayOfWeek dow =
                            DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                    int dayToAdd = 1;
                    if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
                    if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
                    return temporal.plus(dayToAdd, ChronoUnit.DAYS);
                });
        date = date.with(nextWorkingDay);
        LocalDate date1 = LocalDate.of(2014, 3, 18);//2014-03-18
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));//2014-03-23
        LocalDate date3 = date2.with(lastDayOfMonth());//2014-03-31
       /* dayOfWeekInMonth 创建一个新的日期，它的值为同一个月中每一周的第几天
        firstDayOfMonth 创建一个新的日期，它的值为当月的第一天
        firstDayOfNextMonth 创建一个新的日期，它的值为下月的第一天
        firstDayOfNextYear 创建一个新的日期，它的值为明年的第一天
        firstDayOfYear 创建一个新的日期，它的值为当年的第一天
        firstInMonth 创建一个新的日期，它的值为同一个月中，第一个符合星期几要求的值
        lastDayOfMonth 创建一个新的日期，它的值为当月的最后一天
        lastDayOfNextMonth 创建一个新的日期，它的值为下月的最后一天
        lastDayOfNextYear 创建一个新的日期，它的值为明年的最后一天
        lastDayOfYear 创建一个新的日期，它的值为今年的最后一天
        lastInMonth 创建一个新的日期，它的值为同一个月中，最后一个符合星期几要求的值
        next/previous
        创建一个新的日期，并将其值设定为日期调整后或者调整前，第一个符合指定星
                期几要求的日期
        nextOrSame/previousOrSame
        创建一个新的日期，并将其值设定为日期调整后或者调整前，第一个符合指定星
        期几要求的日期，如果该日期已经符合要求，直接返回该对象*/
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.minusHours(1);

        System.out.println("开始时间：" + startTime.format(df) + "，结束时间：" + endTime.format(df));

        LocalDateTime dateTest = LocalDateTime.parse("2018-02-30 12:12:12", df);
        System.out.println("时间自动转化：" + dateTest.toString());

        int daysNum = Period.between(startTime.toLocalDate(), endTime.toLocalDate()).getDays();
        int monthNum = Period.between(startTime.toLocalDate(), endTime.toLocalDate()).getMonths();
        System.out.println("相差天数：" + daysNum);
        System.out.println("相差月数：" + monthNum);

        System.out.println("当前时间向前推6天：" + LocalDateTime.now().minusDays(6));
        System.out.println("当前时间向前推6小时：" + LocalDateTime.now().minusHours(6));
        //在后期使用Period.between（）方法来获取，相差天数、相差月数的时候，发现只能计算同月的天数、同年的月数，不能计算隔月的天数以及隔年的月数！！！相当的坑
        System.out.println(LocalDate.now().toEpochDay() - LocalDate.now().minusDays(5).toEpochDay());//1、查询两个LocalDate的相差天数
        System.out.println(LocalDate.now().until(LocalDate.now().minusDays(5),ChronoUnit.MONTHS));//2、查询两个LocalDate的相差月数
        System.out.println(">>>>>>>>>>>"+LocalDate.now());
        System.out.println(">>>>>>>>>>>"+LocalDateTime.now().format(df));
        LocalDateTime localDateTime=LocalDateTime.parse("2019-12-22 10:20:53",df);
        System.out.println(LocalDateTime.now().until(localDateTime,ChronoUnit.MINUTES));//2、查询两个日期的相差小时

    }
    public static void parseDate(){
        LocalDate date = LocalDate.of(2014, 3, 18);//2014-03-18
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);//20140318
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2014-03-18
        LocalDate date1 = LocalDate.parse("20140318",
                DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18",
                DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
