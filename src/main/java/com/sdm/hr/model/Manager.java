package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;

import javax.persistence.*;

@Entity(name = "manager")
@Table(name = "tbl_hr_managers")
public class Manager extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId" , nullable = false)
    private long userId;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "reportTo" , nullable = false)
    private long reportTo;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getReportTo() {
        return reportTo;
    }

    public void setReportTo(long reportTo) {
        this.reportTo = reportTo;
    }
}
