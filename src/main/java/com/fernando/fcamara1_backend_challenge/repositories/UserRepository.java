package com.fernando.fcamara1_backend_challenge.repositories;

import com.fernando.fcamara1_backend_challenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
