package com.example.spring.services.repository;

import com.example.spring.services.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerReportRepository extends JpaRepository<CustomerReport, Long> {

    @Query("select c from Customer c where c.gender = ?1")
    List<Customer> findByGender(String gender);
}