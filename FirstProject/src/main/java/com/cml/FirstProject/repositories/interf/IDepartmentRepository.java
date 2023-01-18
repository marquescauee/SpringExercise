package com.cml.FirstProject.repositories.interf;

import com.cml.FirstProject.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDepartmentRepository extends JpaRepository<Department, UUID> {

    public Department findByName(String name);
}
