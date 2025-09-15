package com.sample.employee.empassetmanagementapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssetDTO {

    private Long id;
    private String name;
    private String description;
    private String serialNumber;
    private String location;
    private String status; // convert enum to String
}
