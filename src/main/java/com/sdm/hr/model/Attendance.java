package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity(name = "attendance")
@Table(name = "tbl_hr_attendances")
public class Attendance extends DefaultEntity {

    @Id
    private String id;

    @Column(name = "userId" , nullable = false)
    private Long userId;

    @Column(name = "attendanceDate" , nullable = false)
    private Date attendanceDate;

    @Column(name = "inTime" , nullable = false)
    private Time inTime;

    @Column(name = "outTime" , nullable = false)
    private Time outTime;

    @Column(name = "managerId")
    @Nullable
    private Long managerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Time getInTime() {
        return inTime;
    }

    public void setInTime(Time inTime) {
        this.inTime = inTime;
    }

    public Time getOutTime() {
        return outTime;
    }

    public void setOutTime(Time outTime) {
        this.outTime = outTime;
    }

    @Nullable
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(@Nullable Long managerId) {
        this.managerId = managerId;
    }
}
