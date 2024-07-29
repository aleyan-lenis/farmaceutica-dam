package com.example.sistema_farmaceutico.controller;

import com.example.sistema_farmaceutico.models.Factura;
import com.example.sistema_farmaceutico.services.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/factura")
public class FacturaController {

    @Autowired
    private FacturaServiceImpl facturaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Factura>> getAll() {
        return ResponseEntity.ok(facturaService.getFacturas());
    }

    @GetMapping("/getFactura")
    public ResponseEntity<Factura> getFactura(@RequestParam Long id) {
        Optional<Factura> factura = facturaService.getFactura(id);
        return factura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crearFactura")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.addFactura(factura));
    }

    @PostMapping("/actualizarFactura")
    public ResponseEntity<Factura> actualizarFactura(@RequestParam Long id, @RequestBody Factura factura) {
        Factura updatedFactura = facturaService.updateFactura(id, factura);
        return updatedFactura != null ? ResponseEntity.ok(updatedFactura) : ResponseEntity.notFound().build();
    }

    @PostMapping("/eliminarFactura")
    public ResponseEntity<?> eliminarFactura(@RequestParam Long id) {
        facturaService.deleteFactura(id);
        return ResponseEntity.ok().build();
    }
}
