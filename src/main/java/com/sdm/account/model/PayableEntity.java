package com.sdm.account.model;

import com.sdm.core.model.DefaultEntity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "PayableEntity")
@Table(name = "tbl_account_journal_payables")
public class PayableEntity extends DefaultEntity {

    @Id
    private String id;

    @Column(name = "code",nullable = false,unique = true)
    private String code;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name = "amount",nullable = false)
    private Long amount;

    @Column(name = "creditorId",nullable = false)
    private Long creditorId;

    @Column(name = "openDate",nullable = false)
    private Date openDate;

    @Column(name = "dueDate",nullable = false)
    private Date dueDate;

    @Column(name = "note",nullable = true)
    private String note;

    @Column(name="projectId",nullable = true)
    private Integer projectId;

    @ElementCollection
    @CollectionTable(name="tbl_account_payable_attachments",joinColumns = @JoinColumn( name ="payableId"))
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

    public Long getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(Long creditorId) {
        this.creditorId = creditorId;
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

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    @Column(name="contractId",nullable = true)
    private Integer contractId;
}
