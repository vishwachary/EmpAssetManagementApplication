package com.sample.employee.empassetmanagementapplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeDTO {

        private Long id;
        private String name;
        private String designation;
        private String email;
        private long phone;

        private List<AddressDTO> addresses;
        private List<AssetDTO> assets;


}
