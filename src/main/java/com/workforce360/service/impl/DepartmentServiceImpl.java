package com.workforce360.service.impl;

import com.workforce360.entity.Department;
import com.workforce360.repository.DepartmentRepository;
import com.workforce360.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        if(department.getName()==null || department.getName().isBlank()){
            throw new IllegalArgumentException("Department name is required");
        }

        String name = department.getName().trim();
        if(departmentRepository.existsByName(name)){
            throw new IllegalArgumentException("Department already exists");
        }
        department.setName(name);
        department.setActive(true);

        return departmentRepository.save(department);

    }

    @Override
    @Transactional(readOnly=true)
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Department getDepartmentById(Long id) {
        if(id == null || id<=0){
            throw new IllegalArgumentException("Department id must be positive number");
        }
        return departmentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Department not found with ID:"+ id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Department> getActiveDepartments() {
        return departmentRepository.findByActiveTrue();
    }

    @Override
    public Department updateDepartment(Long id, Department updatedDepartment) {
        return null;
    }

    @Override
    public Department deactiveDepartment(Long id) {
        return null;
    }
}
