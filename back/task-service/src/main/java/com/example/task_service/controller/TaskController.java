package com.example.task_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}