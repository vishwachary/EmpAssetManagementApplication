package com.sample.employee.empassetmanagementapplication.service;

import com.sample.employee.empassetmanagementapplication.entity.Address;
import java.util.List;

public interface AddressService {
    Address addAddress(Long empId, Address address);
    List<Address> getAddressesByEmployee(Long empId);
    void deleteAddress(Long addressId);
}
