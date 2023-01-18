package com.cml.FirstProject.controllers;

import com.cml.FirstProject.models.Department;
import com.cml.FirstProject.services.implement.DepartmentService;
import com.cml.FirstProject.services.interf.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DepartmentController {
    private IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") UUID id) {
        return departmentService.getDepartmentById(id);
    }


    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") UUID id, @RequestBody Department department) {
        return departmentService.updatedDepartment(id, department);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") UUID id) {
        boolean deleted = departmentService.deleteDepartmentById(id);

        if(deleted) {
            return "Department deleted Successfully";
        }

        return "Department not found";
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.getDepartmentByName(name);
    }


}
