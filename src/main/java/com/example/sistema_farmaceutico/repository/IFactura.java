package com.example.sistema_farmaceutico.repository;

import com.example.sistema_farmaceutico.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFactura extends JpaRepository<Factura,Long> {
}
