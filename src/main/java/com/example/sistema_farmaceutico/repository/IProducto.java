package com.example.sistema_farmaceutico.repository;

import com.example.sistema_farmaceutico.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto, Long> {
}
