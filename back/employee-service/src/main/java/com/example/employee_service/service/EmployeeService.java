package com.example.employee_service.service;

import java.util.List;

import com.example.employee_service.model.Employee;
import com.example.employee_service.repository.EmployeeRepository;

public class EmployeeService {

      private final EmployeeRepository repo;

      public EmployeeService(EmployeeRepository repo) {
            this.repo = repo;
      }

      public List<Employee> getAll() {
            return repo.findAll();
      }

      public Employee getById(Long id) {
            return repo.findById(id).orElse(null);
      }

      public Employee create(Employee e) {
            return repo.save(e);
      }

      public Employee update(Long id, Employee e) {
            Employee old = repo.findById(id).orElse(null);
            if (old == null)
                  return null;
            old.setName(e.getName());
            old.setEmail(e.getEmail());
            return repo.save(old);
      }

      public void delete(Long id) {
            repo.deleteById(id);
      }

}