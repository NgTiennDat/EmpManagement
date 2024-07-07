package com.datien.crud2.repository;

import com.datien.crud2.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByFirstname(String firstname);
}
