package com.datien.crud2.service.empService;

import com.datien.crud2.exception.EmployeeNotFound;
import com.datien.crud2.model.employee.Employee;
import com.datien.crud2.model.employee.EmployeeDto;
import com.datien.crud2.model.employee.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);
    EmployeeResponseDto getEmployeeById(int employeeId) throws EmployeeNotFound;
    List<EmployeeResponseDto> getAllEmployees();
    EmployeeResponseDto getEmployeeByFirstName(String firstname) throws EmployeeNotFound;
    EmployeeResponseDto updateEmployee(int employeeId, EmployeeDto employeeDto) throws EmployeeNotFound;
    void deleteEmployee(int employeeId);
}
