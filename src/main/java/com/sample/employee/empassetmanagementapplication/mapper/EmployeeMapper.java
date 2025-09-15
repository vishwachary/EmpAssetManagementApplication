package com.sample.employee.empassetmanagementapplication.mapper;

import com.sample.employee.empassetmanagementapplication.dto.AddressDTO;
import com.sample.employee.empassetmanagementapplication.dto.AssetDTO;
import com.sample.employee.empassetmanagementapplication.dto.EmployeeDTO;
import com.sample.employee.empassetmanagementapplication.entity.Address;
import com.sample.employee.empassetmanagementapplication.entity.Asset;
import com.sample.employee.empassetmanagementapplication.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

   public EmployeeDTO toDto(Employee employee)
   {
       EmployeeDTO dto = new EmployeeDTO();
       dto.setId(employee.getId());
       dto.setName(employee.getName());
       dto.setDesignation(employee.getDesignation());
       dto.setEmail(employee.getEmail());
       dto.setPhone(employee.getPhone());

       dto.setAddresses(employee.getAddresses()
               .stream()
               .map(this::toDto)
               .collect(Collectors.toList()));

       dto.setAssets(employee.getAssets()
               .stream()
               .map(this::toDto)
               .collect(Collectors.toList()));

       return dto;

   }

    public AssetDTO toDto(Asset asset) {
        AssetDTO dto = new AssetDTO();
        dto.setId(asset.getId());
        dto.setName(asset.getName());
        dto.setDescription(asset.getDescription());
        dto.setSerialNumber(asset.getSerialNumber());
        dto.setLocation(asset.getLocation());
        dto.setStatus(asset.getStatus().name());
        return dto;
    }

    public AddressDTO toDto(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setZip(address.getZip());
        dto.setCountry(address.getCountry());
        return dto;
    }
}
