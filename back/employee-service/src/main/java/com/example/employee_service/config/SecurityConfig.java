package com.example.employee_service.config;

import com.example.employee_service.security.JwtFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

      @Bean
      public JwtFilter jwtFilterBean(@Value("${jwt.secret}") String secret) {
            return new JwtFilter(secret);
      }

      @Bean
      public FilterRegistrationBean<JwtFilter> jwtFilter(JwtFilter filter) {
            FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
            registrationBean.setFilter(filter);
            registrationBean.addUrlPatterns("/employees", "/employees/*");
            return registrationBean;
      }
}
