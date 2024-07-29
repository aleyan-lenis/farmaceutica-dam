package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Categoria;
import com.example.sistema_farmaceutico.repository.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private ICategoria iCategoria;
    @Override
    public List<Categoria> getCategorias() {
        return iCategoria.findAll();
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        return iCategoria.findById(id).orElse(null);
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return iCategoria.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria categoria) {
        Optional<Categoria> categoriaOptional = iCategoria.findById(id);
        if (categoriaOptional.isPresent()) {
            Categoria categoriaUpdate = categoriaOptional.get();
            if (categoria.getNombreCategoria() != null && !categoria.getNombreCategoria().isEmpty()){
                categoriaUpdate.setNombreCategoria(categoria.getNombreCategoria());
            }
            if(categoria.getDescripcionCategoria() != null && !categoria.getDescripcionCategoria().isEmpty()){
                categoriaUpdate.setDescripcionCategoria(categoria.getDescripcionCategoria());
            }
            return iCategoria.save(categoriaUpdate);
        }
        return null;
    }

    @Override
    public void deleteCategoria(Long id) {
        iCategoria.deleteById(id);
    }
}
