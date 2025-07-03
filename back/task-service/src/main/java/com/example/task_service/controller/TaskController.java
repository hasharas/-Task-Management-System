package com.example.task_service.controller;

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

import com.example.task_service.model.Task;
import com.example.task_service.service.TaskService;
import com.example.task_service.util.EmployeeValidator;

@RestController
@RequestMapping("/tasks")
public class TaskController {
      private final TaskService taskService;
      private final EmployeeValidator employeeValidator;

      public TaskController(TaskService taskService, EmployeeValidator employeeValidator) {
            this.taskService = taskService;
            this.employeeValidator = employeeValidator;
      }

      // end pont hare
      @GetMapping
      public List<Task> getAll() {
            return taskService.getAll();
      }

      @GetMapping("/{id}")
      public ResponseEntity<Task> getById(@PathVariable Long id) {
            return taskService.getById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
      }

      @PostMapping
      public ResponseEntity<?> create(@RequestBody Task task) {
            if (!employeeValidator.employeeExists(task.getEmployeeId())) {
                  return ResponseEntity.badRequest().body("Invalid employee ID");
            }
            return ResponseEntity.ok(taskService.create(task));
      }

      @PutMapping("/{id}")
      public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Task task) {
            if (!employeeValidator.employeeExists(task.getEmployeeId())) {
                  return ResponseEntity.badRequest().body("Invalid employee ID");
            }

            return taskService.update(id, task)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
      }

      @DeleteMapping("/{id}")
      public ResponseEntity<?> delete(@PathVariable Long id) {
            taskService.delete(id);
            return ResponseEntity.ok().build();
      }

}