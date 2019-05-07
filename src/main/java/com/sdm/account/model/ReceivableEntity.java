package com.sdm.account.model;

import com.sdm.core.model.DefaultEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "ReceivableEntity")
@Table(name = "tbl_account_journal_receivables")
public class ReceivableEntity extends DefaultEntity {

    @Id
    private String id;

    @Column(name = "code",nullable = false,unique = true)
    private String code;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name = "amount",nullable = false)
    private Long amount;

    public List<String> getFileId() {
        return fileId;
    }

    public void setFileId(List<String> fileId) {
        this.fileId = fileId;
    }

    @ElementCollection
    @CollectionTable(name="tbl_account_receivable_attachments",joinColumns = @JoinColumn( name ="receivableId"))
    @Column(name="file_id")
    private List<String> fileId;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(Long debtorId) {
        this.debtorId = debtorId;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Column(name = "debtorId",nullable = false)
    private Long debtorId;

    @Column(name = "openDate",nullable = false)
    private Date openDate;

    @Column(name = "dueDate",nullable = false)
    private Date dueDate;

    @Column(name = "note",nullable = true)
    private String note;

    @Column(name="projectId",nullable = true)
    private Integer projectId;
}
