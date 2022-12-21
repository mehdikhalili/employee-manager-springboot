package com.mehdikhalili.employeemanager.repository;

import com.mehdikhalili.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    void deleteById(Long id);
}
