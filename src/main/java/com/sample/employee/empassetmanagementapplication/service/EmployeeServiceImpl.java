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


    EmployeeServiceImpl(EmployeeRepository InjectemployeeRepository)
    {
        this.employeeRepository = InjectemployeeRepository;

    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee empoBeInserted= employee.builder()
                .name(employee.getName())
                .salary(employee.getSalary())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .addresses(employee.getAddresses())
                .assets(employee.getAssets())
                .build();
       return employeeRepository.save(empoBeInserted);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee with ID " + id + " not found", 404));
        return employee;
    }

    @Override
    public Page<Employee> getAllEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);

    }

    @Override
    public Employee updateEmployee(Long id, Employee updated) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
    }
}
