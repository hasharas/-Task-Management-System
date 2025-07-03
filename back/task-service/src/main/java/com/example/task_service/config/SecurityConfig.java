package com.example.task_service.config;

import com.example.task_service.security.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

      @Bean
      public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter jwtFilter) {
            FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>();
            registration.setFilter(jwtFilter);
            registration.addUrlPatterns("/tasks/*", "/tasks");
            return registration;
      }
}
