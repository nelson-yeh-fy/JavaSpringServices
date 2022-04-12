package com.example.spring.services.model;

import javax.persistence.*;

@Entity
@Table(name = "customerReport")
public class CustomerReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "gender")
    private String gender;
    @Column(name = "count")
    private Integer count;

    public CustomerReport(){}

    public CustomerReport(String gender, Integer count){
        this.gender = gender;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender(){ return gender; }

    public void setGender(String gender){ this.gender = gender; }

    public Integer getCount() {  return count; }

    public void setCount(Integer count) { this.count = count; }

    @Override
    public String toString(){
        return "Gender:" + this.gender + ", count:" + this.count;
    }
}