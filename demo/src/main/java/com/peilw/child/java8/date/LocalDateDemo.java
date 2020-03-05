package com.peilw.child.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate today = LocalDate.now();
    }

    public static void getLocalTime() {
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        LocalDate date = LocalDate.parse("2014-03-18");
        time = LocalTime.parse("13:45:20");
    }

    public static void parseDate() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        date1 = LocalDate.of(2014, 3, 18);//2014-03-18
        date2 = date1.plusWeeks(1);//2014-03-25
        date3 = date2.minusYears(3);//2011-03-25
        date4 = date3.plus(6, ChronoUnit.MONTHS);//2011-09-25
    }
}
