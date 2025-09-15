package com.sample.employee.empassetmanagementapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Asset extends Employee {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}