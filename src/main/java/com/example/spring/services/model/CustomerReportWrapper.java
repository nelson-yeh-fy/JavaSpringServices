package com.example.spring.services.model;

import java.util.List;

public class CustomerReportWrapper {

    List<CustomerReport> customerReportList;
/*
    public CustomerReportWrapper(List<CustomerReport> customerReportList){
        this.setCustomerReportList(customerReportList);
    }*/

    public List<CustomerReport> getCustomerReportList() {
        return customerReportList;
    }

    public void setCustomerReportList(List<CustomerReport> customerReportList) {
        this.customerReportList = customerReportList;
    }
}
