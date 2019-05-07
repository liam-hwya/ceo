package com.sdm.hr.model;

import com.sdm.core.model.DefaultEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "leave")
@Table(name = "tbl_hr_leaves")
public class Leave extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( nullable = false)
    private long userId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Enum leaveType;

    @Column(nullable = false)
    private Date fromDate;

    @Column(nullable = false)
    private Date toDate;

    @Column(nullable = false)
    private Enum status;

    @Column(nullable = false)
    private Long managerId;

    @ElementCollection
    @CollectionTable(name = "tbl_hr_leave_attachments", joinColumns = @JoinColumn(name = "leaveId"))
    @Column( nullable = false)
    private List<String> fileId;

    public List<String> getFileId() {
        return fileId;
    }

    public void setFileId(List<String> fileId) {
        this.fileId = fileId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Enum leaveType) {
        this.leaveType = leaveType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
