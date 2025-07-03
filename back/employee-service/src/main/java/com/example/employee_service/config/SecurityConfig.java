package com.example.employee_service.config;

import com.example.employee_service.security.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

      // JWT filter registration
      @Bean
      public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter jwtFilter) {
            FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
            registrationBean.setFilter(jwtFilter);
            registrationBean.addUrlPatterns("/employees/*", "/employees");
            registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
            return registrationBean;
      }

      // CORS filter registration
      @Bean
      public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
            config.setAllowedHeaders(Arrays.asList("*"));
            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);

            FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
            bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
            return bean;
      }
}
