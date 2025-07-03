package com.example.task_service.service;

import com.example.task_service.repository.TaskRepository;

public class TaskService {

      private final TaskRepository repository;

      public TaskService(TaskRepository repository) {
            this.repository = repository;
      }
      // create logics hare
}