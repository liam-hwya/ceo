package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity(name = "calendar")
@Table(name = "tbl_hr_calendars")
public class Calendar extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "day")
    @Nullable
    private int day;

    @Column(name = "month")
    @Nullable
    private Enum month;

    @Column(name = "year")
    @Nullable
    private int year;

    @Column(name = "dayOfWeek")
    @Nullable
    private Enum dayOfWeek;

    @Column(name = "calendarType" , nullable = false)
    private Enum calendarType;

    @Column(name = "note")
    @Nullable
    private String note;

    @Column(name = "dayOff" , nullable = false)
    private Boolean dayOff;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Nullable
    public Enum getMonth() {
        return month;
    }

    public void setMonth(@Nullable Enum month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Nullable
    public Enum getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(@Nullable Enum dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Enum getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(Enum calendarType) {
        this.calendarType = calendarType;
    }

    @Nullable
    public String getNote() {
        return note;
    }

    public void setNote(@Nullable String note) {
        this.note = note;
    }

    public Boolean getDayOff() {
        return dayOff;
    }

    public void setDayOff(Boolean dayOff) {
        this.dayOff = dayOff;
    }
}
