package com.sample.employee.empassetmanagementapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String serialNumber;
    private String location;

    @Enumerated(EnumType.STRING)   // stores enum name as String in DB
    private AssetStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
