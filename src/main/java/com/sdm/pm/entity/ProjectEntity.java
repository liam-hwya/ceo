package com.sdm.pm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.sdm.core.model.DefaultEntity;

@Entity(name = "ProjectEntity")
@Table(name = "tbl_pm_projects")
public class ProjectEntity extends DefaultEntity{

    private static final long serialVersionUID = 739168064520778219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private int contractId;

    @Column(nullable = false)
    private int managerId;

    @Column
    private Date openDate;

    @Column
    private Date closedDate;

    @Column
    private long maxAllowedBudget;

    @Column
    private String cloudLink;

    @Column
    private String note;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tbl_pm_project_attachments", joinColumns = @JoinColumn(name = "projectId", nullable = false))
    @Column(name = "fileId")
    private List<String> file = new ArrayList<String>();

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public long getMaxAllowedBudget() {
        return maxAllowedBudget;
    }

    public void setMaxAllowedBudget(long maxAllowedBudget) {
        this.maxAllowedBudget = maxAllowedBudget;
    }

    public String getCloudLink() {
        return cloudLink;
    }

    public void setCloudLink(String cloudLink) {
        this.cloudLink = cloudLink;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }
}