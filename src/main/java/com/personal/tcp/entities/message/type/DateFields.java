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
        this.day = date.get(Calendar.DAY_OF_MONTH);
        this.month = date.get(Calendar.MONTH);
        this.year = date.get(Calendar.YEAR) % 100;
        this.hour = date.get(Calendar.HOUR);
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

    @Override
    public String toString() {
        Field[] fields = this.getClass().getDeclaredFields();
        String concatFields = "";

        for (Field f : fields) {
            f.setAccessible(true);
            try {
                concatFields = concatFields.concat(" ").concat(f.get(this).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return concatFields;
    }
}
