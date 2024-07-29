package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getCategorias();
    Categoria getCategoriaById(Long id);
    Categoria crearCategoria(Categoria categoria);
    Categoria updateCategoria(Long id,Categoria categoria);
    void deleteCategoria(Long id);
}
