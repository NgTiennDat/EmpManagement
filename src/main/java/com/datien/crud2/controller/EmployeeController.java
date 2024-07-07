package com.datien.crud2.controller;

import com.datien.crud2.exception.EmployeeNotFound;
import com.datien.crud2.model.employee.Employee;
import com.datien.crud2.model.employee.EmployeeDto;
import com.datien.crud2.model.employee.EmployeeResponseDto;
import com.datien.crud2.service.empService.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("/employees")
    public Employee saveEmployee(
            @RequestBody @Valid EmployeeDto employeeDto
    ) {
        return this.service.saveEmployee(employeeDto);
    }

    @GetMapping("/employees")
    public List<EmployeeResponseDto> getAllEmployees() {
        return this.service.getAllEmployees();
    }

    @GetMapping("/employees/{employee-id}")
    public EmployeeResponseDto getEmployeeById(
            @PathVariable("employee-id") Integer employeeId
    ) throws EmployeeNotFound {
      return this.service.getEmployeeById(employeeId);
    }

    @GetMapping("/employees/name/{employee-firstname}")
    public EmployeeResponseDto getEmployeeByName(
            @PathVariable("employee-firstname") String firstname
    ) throws EmployeeNotFound {
        return service.getEmployeeByFirstName(firstname);
    }

    @PatchMapping("/employees/{employee-id}")
    public EmployeeResponseDto updateEmployee(
            @PathVariable("employee-id") Integer employeeId,
            @RequestBody @Valid EmployeeDto employeeDto
    ) throws EmployeeNotFound {
        return this.service.updateEmployee(employeeId, employeeDto);
    }

    @DeleteMapping("/employees/{employee-id}")
    public void deleteEmployeeById(
            @PathVariable("employee-id") Integer employeeId
    ) {
        this.service.deleteEmployee(employeeId);
    }

}
