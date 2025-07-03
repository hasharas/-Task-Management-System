package com.example.task_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.task_service.model.Task;

//repo for task entity
public interface TaskRepository extends JpaRepository<Task, Long> {
      // additinal query methods can be defined here

}