package com.cml.FirstProject.controllers;

import com.cml.FirstProject.errors.DepartmentNotFoundException;
import com.cml.FirstProject.models.Department;
import com.cml.FirstProject.services.interf.IDepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DepartmentController {
    private IDepartmentService departmentService;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        logger.info("Inside getDepartments of DepartmentController");
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") UUID id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") UUID id, @RequestBody Department department) {
        return departmentService.updatedDepartment(id, department);
    }

    @DeleteMapping("/departments/{id}")
    public Department deleteDepartmentById(@PathVariable("id") UUID id) throws DepartmentNotFoundException {
        return departmentService.deleteDepartmentById(id);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.getDepartmentByName(name);
    }


}
