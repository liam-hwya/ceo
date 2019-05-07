package com.sdm.account.model;

import com.sdm.core.model.DefaultEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_account_journals")
public class AccountEntity extends DefaultEntity {

    public enum PaymentType{
        Cash,
        Bank,
        Cheque,
        Other
    }

    public enum Status{
        Requested,
        Approved,
        Paid
    }

    @Id
    private String id;

    public List<String> getFileId() {
        return fileId;
    }

    public void setFileId(List<String> fileId) {
        this.fileId = fileId;
    }

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "code",nullable = false,unique = true)
    private  String code;

    @Column(name = "account_date",nullable = false)
    private Date accountDate;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="amount",nullable = false)
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type",nullable = false)
    private PaymentType paymentType;

    @Column(name = "account_type",nullable = false)
    private String accountType;

    @Column(name = "payment_info",nullable = true)
    private String paymentInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private Status status;

    @Column(name = "accountant_id",nullable = false)
    private Long accountantId;

    @Column(name = "manager_id",nullable = false)
    private Long managerId;

    @Column(name = "contact_id",nullable = true)
    private Long contactId;

    @Column(name = "receivable_id",nullable = true)
    private Integer receivableId;

    @Column(name = "payable_id",nullable = true)
    private Integer payableId;

    @Column(name = "project_id",nullable = true)
    private Integer projectId;

    @Column(name="contract_id",nullable = true)
    private Integer contractId;

    @Column(name = "task_id",nullable = true)
    private Long taskId;

    @ElementCollection
    @CollectionTable(name="tbl_account_journal_attachments",joinColumns = @JoinColumn( name ="journalId"))
    @Column(name="file_id")
    private List<String> fileId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(Long accountantId) {
        this.accountantId = accountantId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Integer getReceivableId() {
        return receivableId;
    }

    public void setReceivableId(Integer receivableId) {
        this.receivableId = receivableId;
    }

    public Integer getPayableId() {
        return payableId;
    }

    public void setPayableId(Integer payableId) {
        this.payableId = payableId;
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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }


}
