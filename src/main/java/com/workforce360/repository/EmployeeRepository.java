package com.workforce360.repository;

import com.workforce360.entity.Employee;
import com.workforce360.enums.EmploymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeCode(String employeeCode);

    Optional<Employee> findByUserId(Long userId);

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByManagerId(Long managerId);

    List<Employee> findByEmploymentStatus(EmploymentStatus employmentStatus);

    boolean existsByEmployeeCode(String employeeCode);

    boolean existsByUserId(Long userId);
}