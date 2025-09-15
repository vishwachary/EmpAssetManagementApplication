package com.sample.employee.empassetmanagementapplication.mapper;

import com.sample.employee.empassetmanagementapplication.dto.AddressDTO;
import com.sample.employee.empassetmanagementapplication.dto.AssetDTO;
import com.sample.employee.empassetmanagementapplication.dto.EmployeeDTO;
import com.sample.employee.empassetmanagementapplication.entity.Address;
import com.sample.employee.empassetmanagementapplication.entity.Asset;
import com.sample.employee.empassetmanagementapplication.entity.AssetStatus;
import com.sample.employee.empassetmanagementapplication.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    // ---------------------- DTO -> Entity ----------------------

    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) return null;

        Employee employee = Employee.builder()
                .id(dto.getId()) // optional: only for update
                .name(dto.getName())
                .designation(dto.getDesignation())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();

        // Map addresses
        List<Address> addresses = dto.getAddresses() != null ?
                dto.getAddresses().stream()
                        .map(addressDto -> {
                            Address address = toEntity(addressDto);
                            address.setEmployee(employee);
                            return address;
                        }).collect(Collectors.toList()) :
                new ArrayList<>();
        employee.setAddresses(addresses);

        // Map assets
        List<Asset> assets = dto.getAssets() != null ?
                dto.getAssets().stream()
                        .map(assetDto -> {
                            Asset asset = toEntity(assetDto);
                            asset.setEmployee(employee);
                            return asset;
                        }).collect(Collectors.toList()) :
                new ArrayList<>();
        employee.setAssets(assets);

        return employee;
    }

    public Asset toEntity(AssetDTO dto) {
        if (dto == null) return null;

        Asset asset = Asset.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .serialNumber(dto.getSerialNumber())
                .location(dto.getLocation())
                .build();

        // Safe enum parsing
        try {
            if (dto.getStatus() != null) {
                asset.setStatus(AssetStatus.valueOf(dto.getStatus()));
            }
        } catch (IllegalArgumentException e) {
            asset.setStatus(AssetStatus.UNKNOWN); // Or handle as needed
        }

        return asset;
    }

    public Address toEntity(AddressDTO dto) {
        if (dto == null) return null;

        return Address.builder()
                .id(dto.getId())
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .zip(dto.getZip())
                .country(dto.getCountry())
                .build();
    }

    // ---------------------- Entity -> DTO ----------------------

    public EmployeeDTO toDto(Employee employee) {
        if (employee == null) return null;

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setDesignation(employee.getDesignation());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());

        dto.setAddresses(employee.getAddresses() != null ?
                employee.getAddresses().stream()
                        .map(this::toDto)
                        .collect(Collectors.toList()) :
                new ArrayList<>());

        dto.setAssets(employee.getAssets() != null ?
                employee.getAssets().stream()
                        .map(this::toDto)
                        .collect(Collectors.toList()) :
                new ArrayList<>());

        return dto;
    }

    public AssetDTO toDto(Asset asset) {
        if (asset == null) return null;

        AssetDTO dto = new AssetDTO();
        dto.setId(asset.getId());
        dto.setName(asset.getName());
        dto.setDescription(asset.getDescription());
        dto.setSerialNumber(asset.getSerialNumber());
        dto.setLocation(asset.getLocation());
        dto.setStatus(asset.getStatus() != null ? asset.getStatus().name() : null);
        return dto;
    }

    public AddressDTO toDto(Address address) {
        if (address == null) return null;

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
