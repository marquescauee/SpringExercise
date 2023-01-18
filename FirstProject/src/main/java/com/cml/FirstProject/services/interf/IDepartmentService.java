package com.cml.FirstProject.services.interf;

import com.cml.FirstProject.models.Department;

import java.util.List;
import java.util.UUID;

public interface IDepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(UUID id);

    public boolean deleteDepartmentById(UUID id);

    public Department updatedDepartment(UUID id, Department department);

    public Department getDepartmentByName(String name);
}
