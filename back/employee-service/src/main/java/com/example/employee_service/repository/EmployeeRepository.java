package com.example.employee_service.repository;

import com.example.employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//repo for employee entity
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
