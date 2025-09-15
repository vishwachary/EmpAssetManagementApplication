package com.sample.employee.empassetmanagementapplication.repo;

import com.sample.employee.empassetmanagementapplication.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
