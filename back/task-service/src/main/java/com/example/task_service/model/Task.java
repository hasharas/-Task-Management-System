package com.example.task_service.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// Task model

public class Task {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String title;

      private String description;

      @Enumerated(EnumType.STRING)
      private Status status;

      private LocalDate dueDate;

      private Long employeeId;
}