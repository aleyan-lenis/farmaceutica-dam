package com.example.sistema_farmaceutico.controller;

import com.example.sistema_farmaceutico.models.User;
import com.example.sistema_farmaceutico.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {

        Optional<User> user = userService.login(loginUser);

        if (user != null) {
            // Aquí puedes generar y devolver un token (por simplicidad, devolveremos un mensaje simple)
            return ResponseEntity.ok("\"Login exitoso\"");
        }

        return ResponseEntity.status(401).body("Credenciales inválidas, usuario no autorizado");
    }

    /*@PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User newUser) {
        // Antes de registrar, verificar si el usuario existe
        Optional<User> existingUser = userService.findByUsername(newUser.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(409).body(null); // 409 Conflict si el usuario ya existe
        }
        return ResponseEntity.ok(userService.save(newUser));
    }*/
}
