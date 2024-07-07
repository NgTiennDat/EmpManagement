package com.datien.crud2.controller;

import com.datien.crud2.model.department.Department;
import com.datien.crud2.model.department.DepartmentDto;
import com.datien.crud2.service.depService.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;
    @PostMapping("/departments")
    public void save(
            @RequestBody Department department
    ) {
        this.service.savedDepartment(department);
    }

    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartments() {
        return this.service.getAllDepartments();
    }

    @GetMapping("/departments/{department-id}")
    public Department getDepartmentById(
            @PathVariable("department-id") Integer departmentId
    ) {
        return this.service.getDepartmentById(departmentId);
    }

    @GetMapping("/departments/name/{department-name}")
    public Department getDepartmentByName(
            @PathVariable("department-name") String name
    ) {
        return this.service.getDepartmentByName(name);
    }

    @DeleteMapping("/departments/{department-id}")
    public void deleteDepartmentById(
            @PathVariable("department-id") Integer departmentId
    ) {
        this.service.deleteDepartment(departmentId);
    }

}
