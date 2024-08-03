package com.example.sistema_farmaceutico.controller;

import com.example.sistema_farmaceutico.models.Categoria;
import com.example.sistema_farmaceutico.services.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

    @GetMapping("/getCategoriaById")
    public ResponseEntity<Categoria> getCategoriaById(@RequestParam Long id) {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }

    @PostMapping("/crearCategoria")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.crearCategoria(categoria));
    }

    @PostMapping("/actualizarCategoria")
    public ResponseEntity<Categoria> actualizarCategoria(@RequestParam Long id,@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.updateCategoria(id, categoria));
    }

    @PostMapping("/eliminarCategoria")
    public ResponseEntity<?> eliminarCategoria(@RequestParam Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok().build();
    }

}
