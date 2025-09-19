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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Iterable<Employee> empList = employeeService.getAllEmployees(page, size);

        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        empList.forEach(employee -> employeeDTOs.add(employeeMapper.toDto(employee)));

        return ResponseEntity.ok(employeeDTOs);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getEmployees(
            @RequestParam(required = false) Long afterId,
            @RequestParam(defaultValue = "10") int limit) {

        // Fetch employees after the given ID
        List<Employee> employees = employeeService.getEmployeesAfterId(afterId, limit);

        // Map to DTOs
        List<EmployeeDTO> employeeDTOs = employees.stream()
                .map(employeeMapper::toDto)
                .toList();

        // Prepare response with cursor info
        Map<String, Object> response = new HashMap<>();
        response.put("employees", employeeDTOs);

        if (!employeeDTOs.isEmpty()) {
            long lastId = employeeDTOs.get(employeeDTOs.size() - 1).getId();
            response.put("nextAfterId", lastId);
            response.put("hasMore", employeeDTOs.size() == limit);
        } else {
            response.put("nextAfterId", null);
            response.put("hasMore", false);
        }

        return ResponseEntity.ok(response);
    }

}
