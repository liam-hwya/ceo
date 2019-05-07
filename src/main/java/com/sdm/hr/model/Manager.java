package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;

import javax.persistence.*;

@Entity(name = "manager")
@Table(name = "tbl_hr_managers")
public class Manager extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userId" , nullable = false)
    private Long userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "reportTo" , nullable = false)
    private Long reportTo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getReportTo() {
        return reportTo;
    }

    public void setReportTo(Long reportTo) {
        this.reportTo = reportTo;
    }
}
