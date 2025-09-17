package com.sample.employee.empassetmanagementapplication.repo;

import com.sample.employee.empassetmanagementapplication.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findTopNOrderByIdAsc(int limit);

    List<Employee> findByIdGreaterThanOrderByIdAsc(Long id, Pageable pageable);
}


