package com.sdm.hr.model;


import com.sdm.core.model.DefaultEntity;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Payment")
@Table(name = "tbl_hr_payment")
public class Payment extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userId", nullable = false)
    private long userId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "fromDate", nullable = false)
    private Date fromDate;

    @Column(name = "toDate")
    @Nullable
    private Date toDate;

    @Column(name = "amountPerMonth", nullable = false)
    private Long amountPerMonth;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Nullable
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(@Nullable Date toDate) {
        this.toDate = toDate;
    }

    public Long getAmountPerMonth() {
        return amountPerMonth;
    }

    public void setAmountPerMonth(Long amountPerMonth) {
        this.amountPerMonth = amountPerMonth;
    }
}
