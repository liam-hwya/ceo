package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity(name = "WorkingHour")
@Table(name = "tbl_hr_workinghours")
public class WorkingHour extends DefaultEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "dayOfWeek", nullable = false)
    private Integer dayOfWeek;

    @Column(name = "fromTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fromTime;

    @Column(name = "toTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date toTime;

    @Transient
    private Boolean checkedDay;

    public Boolean getCheckedDay() {
        return checkedDay;
    }

    public void setCheckedDay(Boolean checkedDay) {
        this.checkedDay = checkedDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @DateTimeFormat(pattern = "HH:mm")
    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    @DateTimeFormat(pattern = "HH:mm")
    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
}
