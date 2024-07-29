package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getClientes();
    Cliente getCliente(Long id);
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Long id,Cliente cliente);
    void deleteCliente(Long id);
}
