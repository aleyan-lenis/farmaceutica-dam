package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.User;
import com.example.sistema_farmaceutico.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> login(User user) {
        Optional<User> usuario = this.findByUsername(user.getUsername());
        if(usuario.isPresent() && usuario.get().getPassword().equals(user.getPassword())){
            return usuario;
        }
        return null;
    }
}
