package com.cml.FirstProject.services.implement;

import com.cml.FirstProject.models.Department;
import com.cml.FirstProject.repositories.interf.IDepartmentRepository;
import com.cml.FirstProject.services.interf.IDepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
