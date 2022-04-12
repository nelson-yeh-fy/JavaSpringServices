package com.example.spring.services.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.spring.services.model.*;
import com.example.spring.services.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerReportController {

    @Autowired
    private CustomerReportRepository customerReportRepository;

    @GetMapping("/customerReports")
    public ResponseEntity<List<CustomerReport>> getAllCustomerReports() {
        try {
            List<CustomerReport> res = new ArrayList<>();
            res.addAll(customerReportRepository.findAll());
            if (res.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customerReports/{id}")
    public ResponseEntity<CustomerReport> findCustomerReportsById(@PathVariable long id) {
        Optional<CustomerReport> reportData = customerReportRepository.findById(id);
        if (reportData.isPresent()) {
            return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customerReports")
    public ResponseEntity<CustomerReport> createCustomerReports(@RequestBody CustomerReport customerReport) {
        try {
            CustomerReport _report = customerReportRepository
                    .save(new CustomerReport(customerReport.getGender(), customerReport.getCount()) );
            return new ResponseEntity<>(_report, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customerReports/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerReports(@PathVariable("id") long id) {
        try {
            customerReportRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/customerReports")
    public ResponseEntity<HttpStatus> deleteAllCustomerReports() {
        try {
            customerReportRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
