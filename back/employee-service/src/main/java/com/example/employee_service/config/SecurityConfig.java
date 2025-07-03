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

// package com.example.employee_service.config;

// import com.example.employee_service.security.JwtFilter;
// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.web.SecurityFilterChain;

// // import static org.springframework.security.config.Customizer.withDefaults;

// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;

// @Configuration
// public class SecurityConfig {

// @Bean
// public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter
// jwtFilter) {
// FilterRegistrationBean<JwtFilter> registration = new
// FilterRegistrationBean<>();
// registration.setFilter(jwtFilter);
// registration.addUrlPatterns("/tasks", "/tasks/*");
// return registration;
// }

// // ✅ Disable default security login and allow filter-based handling
// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// http.csrf(csrf -> csrf.disable())
// .authorizeHttpRequests(auth -> auth
// .anyRequest().permitAll() // Let your JwtFilter handle access
// );
// return http.build();
// }
// }
