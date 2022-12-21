package com.mehdikhalili.employeemanager.service;

import com.mehdikhalili.employeemanager.exception.EmployeeNotFoundException;
import com.mehdikhalili.employeemanager.model.Employee;
import com.mehdikhalili.employeemanager.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee findEmployee(Long id) {
        return repository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
