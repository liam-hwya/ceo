package com.sdm.ceo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.sdm.core.model.DefaultEntity;

@Entity(name = "ContractEntity")
@Table(name = "tbl_contracts")
public class ContractEntity extends DefaultEntity{

    private static final long serialVersionUID = 739168064520778219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Long toContact;

    @Column(nullable = false)
    private Long amount;

    @Column
    private String cloudLink;

    @Column(nullable = false)
    private Date contractDate;

    @Column
    private Integer productId;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long signId;

    @Column
    private String note;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tbl_contract_attachments", joinColumns = @JoinColumn(name = "contractId", nullable = false))
    @Column(name = "fileId")
    private List<String> file = new ArrayList<String>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getToContact() {
        return toContact;
    }

    public void setToContact(Long toContact) {
        this.toContact = toContact;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCloudLink() {
        return cloudLink;
    }

    public void setCloudLink(String cloudLink) {
        this.cloudLink = cloudLink;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getSignId() {
        return signId;
    }

    public void setSignId(Long signId) {
        this.signId = signId;
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