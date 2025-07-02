package com.example.auth_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth_service.repository.UserRepository;
import com.example.auth_service.security.JwtUtil;

import lombok.Data;

@RestController
@RequestMapping("/auth")
public class AuthController {

      private final UserRepository userRepository;
      private final PasswordEncoder passwordEncoder;
      private final JwtUtil jwtUtil;

      public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.jwtUtil = jwtUtil;
      }

      @PostMapping("/login")
      public ResponseEntity<?> login(@RequestBody AuthRequest request) {
            return userRepository.findByUsername(request.getUsername())
                        .map(user -> {
                              if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                                    String token = jwtUtil.generateToken(user.getUsername());
                                    return ResponseEntity.ok(new AuthResponse(token));
                              } else {
                                    return ResponseEntity.status(401).body("Invalid password");
                              }
                        })
                        .orElseGet(() -> ResponseEntity.status(401).body("User not found"));
      }

      @Data
      public static class AuthRequest {
            private String username;
            private String password;
      }

      @Data
      public static class AuthResponse {
            private final String token;
      }
}