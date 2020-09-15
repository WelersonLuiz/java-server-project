package com.personal.tcp.entities.message.type;

import java.lang.reflect.Field;
import java.util.Calendar;

public class DateFields {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;

    public DateFields(Calendar date) {
        this.day    = date.get(Calendar.DAY_OF_MONTH);
        this.month  = date.get(Calendar.MONTH)+1;
        this.year   = date.get(Calendar.YEAR) % 100;
        this.hour   = date.get(Calendar.HOUR);
        this.minute = date.get(Calendar.MINUTE);
        this.second = date.get(Calendar.SECOND);
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
    }

    public String toString(){
        return day + " " + month + " " + year + " " + hour + " " + minute  + " " + second;
    }

    public String toHexString() {
        return String.format("%02X", day) + " " +
                String.format("%02X", month) + " " +
                String.format("%02X", year) + " " +
                String.format("%02X", hour) + " " +
                String.format("%02X", minute) + " " +
                String.format("%02X", second);
    }
}
