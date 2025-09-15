package com.sample.employee.empassetmanagementapplication.controller;

import com.sample.employee.empassetmanagementapplication.dto.EmployeeDTO;
import com.sample.employee.empassetmanagementapplication.entity.Employee;
import com.sample.employee.empassetmanagementapplication.mapper.EmployeeMapper;
import com.sample.employee.empassetmanagementapplication.service.EmployeeService;
import com.sample.employee.empassetmanagementapplication.service.EmployeeServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Iterable<Employee> empList = employeeService.getAllEmployees(page, size);

        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        empList.forEach(employee -> employeeDTOs.add(employeeMapper.toDto(employee)));

        return ResponseEntity.ok(employeeDTOs);
    }
}
