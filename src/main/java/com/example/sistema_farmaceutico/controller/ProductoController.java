package com.example.sistema_farmaceutico.controller;

import com.example.sistema_farmaceutico.models.Producto;
import com.example.sistema_farmaceutico.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Producto>> getAll() {
        return ResponseEntity.ok(productoService.getProductos());
    }

    @GetMapping("/getProducto")
    public ResponseEntity<Producto> getProducto(@RequestParam Long id) {
        Optional<Producto> producto = productoService.getProducto(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crearProducto")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.createProducto(producto));
    }

    @PostMapping("/actualizarProducto")
    public ResponseEntity<Producto> actualizarProducto(@RequestParam Long id, @RequestBody Producto producto) {
        Producto updatedProducto = productoService.updateProducto(id, producto);
        return updatedProducto != null ? ResponseEntity.ok(updatedProducto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/eliminarProducto")
    public ResponseEntity<?> eliminarProducto(@RequestParam Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok().build();
    }
}
