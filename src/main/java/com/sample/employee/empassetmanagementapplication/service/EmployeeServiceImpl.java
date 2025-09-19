package com.sample.employee.empassetmanagementapplication.service;

import com.sample.employee.empassetmanagementapplication.entity.Employee;
import com.sample.employee.empassetmanagementapplication.exception.EmployeeNotFoundException;
import com.sample.employee.empassetmanagementapplication.repo.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getAddresses() != null) {
            employee.getAddresses().forEach(address -> address.setEmployee(employee));
        }
        if (employee.getAssets() != null) {
            employee.getAssets().forEach(asset -> asset.setEmployee(employee));
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee with ID " + id + " not found", 404));
    }

    @Override
    public List<Employee> getEmployeesAfterId(Long afterId, int limit) {
        if (afterId == null) {
            return employeeRepository.findAllByOrderByIdAsc(PageRequest.of(0, limit));
        } else {
            return employeeRepository.findByIdGreaterThanOrderByIdAsc(afterId, PageRequest.of(0, limit));
        }
    }

    @Override
    public Iterable<Employee> getAllEmployees(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public Employee updateEmployee(Long id, Employee updated) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteEmployee(Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

