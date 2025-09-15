package com.sample.employee.empassetmanagementapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends Employee {

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}