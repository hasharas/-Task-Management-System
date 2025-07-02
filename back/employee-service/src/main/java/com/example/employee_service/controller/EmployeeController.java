
package com.example.employee_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.model.Employee;
import com.example.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

      private final EmployeeService service;

      public EmployeeController(EmployeeService service) {
            this.service = service;
      }

      @GetMapping
      public List<Employee> getAll() {
            return service.getAll();
      }

      @GetMapping("/{id}")
      public ResponseEntity<Employee> getById(@PathVariable Long id) {
            Employee e = service.getById(id);
            return (e != null) ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
      }

      @PostMapping
      public Employee create(@RequestBody Employee e) {
            return service.create(e);
      }

      @PutMapping("/{id}")
      public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee e) {
            Employee updated = service.update(id, e);
            return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
      }

      @DeleteMapping("/{id}")
      public ResponseEntity<?> delete(@PathVariable Long id) {
            service.delete(id);
            return ResponseEntity.ok().build();
      }
}