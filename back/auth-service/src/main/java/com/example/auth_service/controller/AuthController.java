package com.example.auth_service.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth_service.repository.UserRepository;
import com.example.auth_service.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

      private final UserRepository userRepository;
      private final PasswordEncoder passwordEncoder;
      private final JwtUtil jwtUtil;

      public AuthController() {

      }

}