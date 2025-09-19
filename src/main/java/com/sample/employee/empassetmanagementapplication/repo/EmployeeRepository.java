package com.sample.employee.empassetmanagementapplication.repo;

import com.sample.employee.empassetmanagementapplication.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Get a list of employees ordered by ID ascending with a dynamic limit
    List<Employee> findAllByOrderByIdAsc(Pageable pageable);

    // Get employees with ID greater than a given value, ordered by ID ascending, with dynamic limit
    List<Employee> findByIdGreaterThanOrderByIdAsc(Long id, Pageable pageable);
}


