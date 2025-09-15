package com.sample.employee.empassetmanagementapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
