package com.datien.crud2.service.depService;

import com.datien.crud2.model.department.Department;
import com.datien.crud2.model.department.DepartmentDto;
import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {

    public DepartmentDto toDto(Department department) {
        return new DepartmentDto(department.getName());
    }
}
