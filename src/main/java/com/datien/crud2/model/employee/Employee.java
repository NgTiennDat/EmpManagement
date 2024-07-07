package com.datien.crud2.model.employee;

import com.datien.crud2.model.department.Department;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "_employee")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private double salary;

    @ManyToOne
    @JoinColumn(
            name = "department_id"
    )
    @JsonBackReference
    private Department department;
}
