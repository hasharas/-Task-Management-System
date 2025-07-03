package com.example.task_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.task_service.model.Task;
import com.example.task_service.repository.TaskRepository;

@Service
public class TaskService {

      private final TaskRepository repository;

      public TaskService(TaskRepository repository) {
            this.repository = repository;
      }
      // create logics hare

      public List<Task> getAll() {
            return repository.findAll();
      }

      public Optional<Task> getById(Long id) {
            return repository.findById(id);
      }

      public Task create(Task task) {
            return repository.save(task);
      }

      public Optional<Task> update(Long id, Task task) {
            return repository.findById(id).map(existing -> {
                  existing.setTitle(task.getTitle());
                  existing.setDescription(task.getDescription());
                  existing.setStatus(task.getStatus());
                  existing.setDueDate(task.getDueDate());
                  existing.setEmployeeId(task.getEmployeeId());
                  return repository.save(existing);
            });
      }

      public void delete(Long id) {
            repository.deleteById(id);
      }

}