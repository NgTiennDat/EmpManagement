package com.datien.crud2.service.depService;

import com.datien.crud2.model.department.Department;
import com.datien.crud2.model.department.DepartmentDto;
import com.datien.crud2.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository repository;

    @Override
    public void savedDepartment(Department department) {
        repository.save(department);
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with name: " + name));
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return repository.findAll()
                .stream().map(departmentMapper::toDto)
                .toList();
    }

    @Override
    public void deleteDepartment(int id) {
        repository.deleteById(id);
    }
}
