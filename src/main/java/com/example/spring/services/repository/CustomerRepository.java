package com.example.spring.services.repository;

import com.example.spring.services.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.firstName = ?1")
    List<Customer> findByFirstName(String firstName);
    @Query("select c from Customer c where c.gender = ?1")
    List<Customer> findByGender(String gender);
}