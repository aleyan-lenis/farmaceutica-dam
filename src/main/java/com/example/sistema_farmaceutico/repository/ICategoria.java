package com.example.sistema_farmaceutico.repository;

import com.example.sistema_farmaceutico.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoria extends JpaRepository<Categoria, Long> {
}
