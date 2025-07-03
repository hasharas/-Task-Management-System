// set up password encoder

package com.example.auth_service.config;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
      // public access to 
      @Bean
      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                        .csrf(csrf -> csrf.disable())
                        .authorizeHttpRequests(auth -> auth
                                    .requestMatchers("/auth/**").permitAll() // Allow /auth/login
                                    .anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults());

            return http.build();
      }

      // password encoder bean
      @Bean
      public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
      }
}