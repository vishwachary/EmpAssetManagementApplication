package com.sample.employee.empassetmanagementapplication.controller;

import com.sample.employee.empassetmanagementapplication.dto.EmployeeDTO;
import com.sample.employee.empassetmanagementapplication.entity.Employee;
import com.sample.employee.empassetmanagementapplication.mapper.EmployeeMapper;
import com.sample.employee.empassetmanagementapplication.service.EmployeeService;
import com.sample.employee.empassetmanagementapplication.service.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmpController {

    private EmployeeServiceImpl employeeServiceImpl;
    private EmployeeMapper employeeMapper;

    public EmpController(EmployeeServiceImpl employeeServiceImpl ,EmployeeMapper employeeMapper) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.employeeMapper = employeeMapper;
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee) {

        return ResponseEntity.ok(employeeMapper.toDto(employeeServiceImpl.createEmployee(employee)));

    }
}
