package com.example.sistema_farmaceutico.repository;

import com.example.sistema_farmaceutico.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICliente extends JpaRepository<Cliente, Long> {
}
