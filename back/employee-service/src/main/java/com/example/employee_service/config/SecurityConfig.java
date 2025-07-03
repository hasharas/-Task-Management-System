package com.example.employee_service.config;

import com.example.employee_service.security.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

      @Bean
      public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter jwtFilter) {
            FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
            registrationBean.setFilter(jwtFilter);
            registrationBean.addUrlPatterns("/employees/*", "/employees");
            return registrationBean;
      }
}
