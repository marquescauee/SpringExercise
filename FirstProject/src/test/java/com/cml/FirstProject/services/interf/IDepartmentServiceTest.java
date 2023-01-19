package com.cml.FirstProject.services.interf;

import com.cml.FirstProject.models.Department;
import com.cml.FirstProject.repositories.implement.DepartmentRepository;
import com.cml.FirstProject.repositories.interf.IDepartmentRepository;
import com.cml.FirstProject.services.implement.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDepartmentServiceTest {

    @Autowired
    private IDepartmentService departmentService;

    @MockBean
    private IDepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        UUID newId = UUID.randomUUID();

        Department department = Department.builder()
                                    .name("IT")
                                    .address("Testing")
                                    .code("IT-06")
                                    .id(newId)
                                    .build();

        Mockito.when(departmentRepository.findByName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getName());
    }
}