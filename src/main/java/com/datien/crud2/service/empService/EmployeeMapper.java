package com.datien.crud2.service.empService;

import com.datien.crud2.model.department.Department;
import com.datien.crud2.model.employee.Employee;
import com.datien.crud2.model.employee.EmployeeDto;
import com.datien.crud2.model.employee.EmployeeResponseDto;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public Employee toEmployee(EmployeeDto employeeDto) {
        var employee = new Employee();
        employee.setFirstname(employeeDto.firstname());
        employee.setLastname(employeeDto.lastname());
        employee.setEmail(employeeDto.email());
        employee.setSalary(employeeDto.salary());

        var department = new Department();
        department.setId(employeeDto.departmentId());

        employee.setDepartment(department);
        return employee;
    }

    public EmployeeResponseDto toEmployeeResponseDto(Employee employee) {
        return new EmployeeResponseDto(employee.getFirstname(), employee.getLastname(), employee.getEmail());
    }
}
