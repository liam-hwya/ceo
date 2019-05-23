package com.sdm.hr.repository;

import com.sdm.hr.model.WorkingHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface WorkingHourRepository extends JpaRepository<WorkingHour,Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from WorkingHour wh where wh.userId=:userId")
    void deleteByUserId(@Param("userId") Long userId);

    List<WorkingHour> findByUserId(Long userId);
}
