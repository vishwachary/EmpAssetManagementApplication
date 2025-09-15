package com.sample.employee.empassetmanagementapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;
    private String email;
    private long phone;
    private long salary;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee", cascade = CascadeType.ALL)
    @Builder.Default // ensures non-null list when using builder
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.ALL)
    @Builder.Default // ensures non-null list when using builder
    private List<Asset> assets = new ArrayList<>();;


}
