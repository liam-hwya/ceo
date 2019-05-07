package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;

import javax.persistence.*;
import java.sql.Time;

@Entity(name = "workingHour")
@Table(name = "tbl_hr_workinghours")
public class WorkingHour extends DefaultEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userId", nullable = false)
    private long userId;

    @Column(name = "dayOfWeek", nullable = false)
    private int dayOfWeek;

    @Column(name = "fromTime", nullable = false)
    private Time fromTime;

    @Column(name = "toTime", nullable = false)
    private Time toTime;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getFromTime() {
        return fromTime;
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public Time getToTime() {
        return toTime;
    }

    public void setToTime(Time toTime) {
        this.toTime = toTime;
    }

}
