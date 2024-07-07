package com.datien.crud2.model.employee;

public record EmployeeDto(
        String firstname,
        String lastname,
        String email,
        double salary,
        Integer departmentId
) {
}
