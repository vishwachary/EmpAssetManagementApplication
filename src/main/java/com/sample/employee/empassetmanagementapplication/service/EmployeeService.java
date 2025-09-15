package com.sample.employee.empassetmanagementapplication.service;

import com.sample.employee.empassetmanagementapplication.entity.Asset;
import com.sample.employee.empassetmanagementapplication.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, Employee updated);
    void deleteEmployee(Long id);
}

