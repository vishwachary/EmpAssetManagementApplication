package com.sample.employee.empassetmanagementapplication.controller;

import com.sample.employee.empassetmanagementapplication.dto.EmployeeDTO;
import com.sample.employee.empassetmanagementapplication.entity.Employee;
import com.sample.employee.empassetmanagementapplication.mapper.EmployeeMapper;
import com.sample.employee.empassetmanagementapplication.service.EmployeeService;
import com.sample.employee.empassetmanagementapplication.service.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmpController {

    private final EmployeeService employeeService;;
    private final EmployeeMapper employeeMapper;

    public EmpController(EmployeeService employeeServiceImpl ,EmployeeMapper employeeMapper) {
        this.employeeService = employeeServiceImpl;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);  // Convert DTO -> Entity
        Employee savedEmployee = employeeService.createEmployee(employee);
        EmployeeDTO responseDTO = employeeMapper.toDto(savedEmployee);  // Entity -> DTO
        return ResponseEntity.ok(responseDTO);
       // return ResponseEntity.ok(employeeMapper.toDto(employeeService.createEmployee(employee)));

    }
}
