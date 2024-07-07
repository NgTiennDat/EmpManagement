package com.datien.crud2.service.empService;

import com.datien.crud2.exception.EmployeeNotFound;
import com.datien.crud2.model.employee.Employee;
import com.datien.crud2.model.employee.EmployeeDto;
import com.datien.crud2.model.employee.EmployeeResponseDto;
import com.datien.crud2.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        return repository.save(mapper.toEmployee(employeeDto));
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(mapper::toEmployeeResponseDto)
                .sorted(Comparator.comparing(EmployeeResponseDto::firstname))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto getEmployeeByFirstName(String firstname) throws EmployeeNotFound {
        return repository.findByFirstname(firstname)
                .map(mapper::toEmployeeResponseDto)
                .orElseThrow(() -> new EmployeeNotFound("No employee found with firstname: " + firstname));
    }

    @Override
    public EmployeeResponseDto updateEmployee(int employeeId, EmployeeDto employeeDto) throws EmployeeNotFound {
        var updatedEmployee = repository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFound("No employee found with id " + employeeId));

        updatedEmployee.setFirstname(employeeDto.firstname());
        updatedEmployee.setLastname(employeeDto.lastname());
        updatedEmployee.setEmail(employeeDto.email());
        updatedEmployee.setSalary(employeeDto.salary());

        var updatedEmployeeSaved = repository.save(updatedEmployee);
        return mapper.toEmployeeResponseDto(updatedEmployeeSaved);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(int empId) throws EmployeeNotFound {
        var employee = repository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFound("No employee found with id " + empId));
        return mapper.toEmployeeResponseDto(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        repository.deleteById(employeeId);
    }
}
