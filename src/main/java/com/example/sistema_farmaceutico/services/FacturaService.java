package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> getFacturas();
    Optional<Factura> getFactura(Long id);
    Factura addFactura(Factura factura);
    Factura updateFactura(Long id,Factura factura);
    void deleteFactura(Long id);
}
