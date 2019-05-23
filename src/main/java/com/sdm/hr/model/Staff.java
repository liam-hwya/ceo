package com.sdm.hr.model;

import com.sdm.master.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;

import javax.validation.Valid;
import java.util.List;


public class Staff {
    @Valid
    private UserEntity user;

    private Payment payment;

    private List<WorkingHour> workingHours;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<WorkingHour> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WorkingHour> workingHours) {
        this.workingHours = workingHours;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
