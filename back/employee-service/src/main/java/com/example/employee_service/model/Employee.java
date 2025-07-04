package com.example.employee_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// Employee model
public class Employee {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)

      private Long id;
      // i decided thare name and email
      private String name;

      private String email;
}