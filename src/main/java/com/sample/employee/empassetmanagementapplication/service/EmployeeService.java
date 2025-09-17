package com.sample.employee.empassetmanagementapplication.service;

import com.sample.employee.empassetmanagementapplication.entity.Asset;
import com.sample.employee.empassetmanagementapplication.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Iterable<Employee> getAllEmployees(int page, int size);
    Employee updateEmployee(Long id, Employee updated);
    void deleteEmployee(Long id);

    public List<Employee> getEmployeesAfterId(Long afterId, int limit);
}

