package com.sample.employee.empassetmanagementapplication.service;

import com.sample.employee.empassetmanagementapplication.dto.EmployeeDTO;
import com.sample.employee.empassetmanagementapplication.entity.Employee;
import com.sample.employee.empassetmanagementapplication.exception.EmployeeNotFoundException;
import com.sample.employee.empassetmanagementapplication.mapper.EmployeeMapper;
import com.sample.employee.empassetmanagementapplication.repo.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository InjectemployeeRepository)
    {
        this.employeeRepository = InjectemployeeRepository;

    }

    @Override
    public Employee createEmployee(Employee employee) {
        // Fix back-references
        if (employee.getAddresses() != null) {
            employee.getAddresses().forEach(address -> address.setEmployee(employee));
        }
        if (employee.getAssets() != null) {
            employee.getAssets().forEach(asset -> asset.setEmployee(employee));
        }

        return employeeRepository.save(employee); // cascade saves children
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee with ID " + id + " not found", 404));
        return employee;
    }

    @Override
        public Iterable<Employee> getAllEmployees(int page, int size) {
            Pageable pageable = PageRequest.of(page, size);
            return employeeRepository.findAll(pageable).getContent(); // returns a List<Employee>
        }



    @Override
    public Employee updateEmployee(Long id, Employee updated) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
    }
}
