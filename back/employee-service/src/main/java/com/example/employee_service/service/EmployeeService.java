package com.example.employee_service.service;

import com.example.employee_service.repository.EmployeeRepository;

public class EmployeeService {

      private final EmployeeRepository repo;

      public EmployeeService(EmployeeRepository repo) {
            this.repo = repo;
      }

}