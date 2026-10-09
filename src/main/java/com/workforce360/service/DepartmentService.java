package com.workforce360.service;

import com.workforce360.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    List<Department> getActiveDepartments();

    Department updateDepartment(Long id, Department updatedDepartment);

    Department deactiveDepartment(Long id);

}
