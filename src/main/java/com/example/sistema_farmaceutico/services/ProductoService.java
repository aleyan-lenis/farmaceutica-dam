package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> getProductos();
    Optional<Producto> getProducto(Long id);
    Producto createProducto(Producto producto);
    Producto updateProducto(Long id,Producto producto);
    void deleteProducto(Long id);
}
