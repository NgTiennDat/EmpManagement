package com.datien.crud2.service.depService;

import com.datien.crud2.model.department.Department;
import com.datien.crud2.model.department.DepartmentDto;

import java.util.List;

public interface DepartmentService{
    void savedDepartment(Department department);
    Department getDepartmentById(int id);
    Department getDepartmentByName(String name);
    List<DepartmentDto> getAllDepartments();
    void deleteDepartment(int id);
}
