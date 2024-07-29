package com.example.sistema_farmaceutico.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private float precioProducto;
    private int cantidadStockProducto;
    @ManyToOne
    @JoinColumn(name = "categoriaProductoId", nullable = false)
    private Categoria categoria;
}
