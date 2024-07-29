package com.example.sistema_farmaceutico.controller;

import com.example.sistema_farmaceutico.models.Cliente;
import com.example.sistema_farmaceutico.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cliente")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.getClientes());
    }

    @GetMapping("/getCliente")
    public ResponseEntity<Cliente> getCliente(@RequestParam Long id) {
        return ResponseEntity.ok(clienteService.getCliente(id));
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    @PostMapping("/actualizarCliente")
    public ResponseEntity<Cliente> actualizarCliente(@RequestParam Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.updateCliente(id, cliente));
    }

    @PostMapping("/eliminarCliente")
    public ResponseEntity<?> eliminarCliente(@RequestParam Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().build();
    }
}
