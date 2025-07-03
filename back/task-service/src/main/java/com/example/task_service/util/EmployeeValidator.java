package com.example.task_service.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//validates if an employee exists by checking the employee service
@Component
public class EmployeeValidator {

      @Value("${employee.service.url}")
      private String employeeServiceUrl;

      private final RestTemplate restTemplate = new RestTemplate();

      public boolean employeeExists(Long id, String jwtToken) {
            try {
                  String url = employeeServiceUrl + "/" + id;

                  HttpHeaders headers = new HttpHeaders();
                  headers.set("Authorization", "Bearer " + jwtToken);

                  HttpEntity<Void> entity = new HttpEntity<>(headers);

                  ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
                  return response.getStatusCode().is2xxSuccessful();

            } catch (Exception e) {
                  System.err.println("Error validating employee: " + e.getMessage());
                  return false;
            }
      }
}
