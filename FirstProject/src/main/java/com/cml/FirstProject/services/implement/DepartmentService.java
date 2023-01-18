package com.cml.FirstProject.services.implement;

import com.cml.FirstProject.models.Department;
import com.cml.FirstProject.repositories.interf.IDepartmentRepository;
import com.cml.FirstProject.services.interf.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

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

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(UUID id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public boolean deleteDepartmentById(UUID id) {

        try {
            Department departmentDB = departmentRepository.findById(id).get();

            departmentRepository.deleteById(id);

            return true;

        } catch(NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public Department updatedDepartment(UUID id, Department department) {

        try {
            Department departmentDB = departmentRepository.findById(id).get();

            if(Objects.nonNull(department.getName()) && !department.getName().isBlank()) {
                departmentDB.setName(department.getName());
            }

            if(Objects.nonNull(department.getCode()) && !department.getCode().isBlank()) {
                departmentDB.setCode(department.getCode());
            }

            if(Objects.nonNull(department.getAddress()) && !department.getAddress().isBlank()) {
                departmentDB.setAddress(department.getAddress());
            }

            return departmentRepository.save(departmentDB);

        } catch(NoSuchElementException e) {
            return null;
        }
    }

}
