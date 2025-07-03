package com.example.task_service.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class EmployeeValidator {

      @Value("${employee.service.url}")
      private String employeeServiceUrl;

      private final RestTemplate restTemplate = new RestTemplate();

      public boolean employeeExists(Long id) {
            try {
                  String url = employeeServiceUrl + "/" + id;
                  restTemplate.getForObject(url, Object.class);
                  return true;
            } catch (Exception e) {
                  return false;
            }
      }
}