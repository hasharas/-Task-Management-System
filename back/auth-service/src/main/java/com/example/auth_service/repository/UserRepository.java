package com.example.auth_service.repository;

import com.example.auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//repo for user entity
public interface UserRepository extends JpaRepository<User, Long> {
      Optional<User> findByUsername(String username);
}