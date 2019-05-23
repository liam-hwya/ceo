package com.sdm.hr.repository;

import com.sdm.hr.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    @Query("SELECT p from Payment p where p.userId = :id")
    Payment findByUserIdForPayment(@Param("id") Long id);

}
