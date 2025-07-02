package com.example.auth_service.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.auth_service.model.User;
import com.example.auth_service.repository.UserRepository;

// Data seeder class  seed initial data into the database (admin ,and pswrd)
@Component
public class DataSeeder implements CommandLineRunner {

      private final UserRepository userRepository;
      private final PasswordEncoder passwordEncoder;

      // Constructor injection for UserRepository , PasswordEncoder
      public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;

      }

      @Override
      public void run(String... args) throws Exception {
            if (userRepository.findByUsername("admin").isEmpty()) {
                  User user = new User();
                  user.setUsername("admin");
                  user.setPassword(passwordEncoder.encode("password"));
                  userRepository.save(user);
                  System.out.println(" Seeded admin user with password 'password'");
            }

      }
}