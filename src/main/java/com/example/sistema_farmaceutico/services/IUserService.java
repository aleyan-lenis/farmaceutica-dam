package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String username);
    Optional<User> login(User user);
}
