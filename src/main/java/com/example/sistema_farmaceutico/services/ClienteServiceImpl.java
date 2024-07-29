package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Cliente;
import com.example.sistema_farmaceutico.repository.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ICliente iCliente;

    @Override
    public List<Cliente> getClientes() {
        return iCliente.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return iCliente.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return iCliente.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = iCliente.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente clienteUpdate = clienteOptional.get();

            if (cliente.getNombre() != null && !cliente.getNombre().isEmpty()) {
                clienteUpdate.setNombre(cliente.getNombre());
            }

            if (cliente.getApellido() != null && !cliente.getApellido().isEmpty()) {
                clienteUpdate.setApellido(cliente.getApellido());
            }

            if (cliente.getTelefono() != null && !cliente.getTelefono().isEmpty()) {
                clienteUpdate.setTelefono(cliente.getTelefono());
            }

            if (cliente.getEmail() != null && !cliente.getEmail().isEmpty()) {
                clienteUpdate.setEmail(cliente.getEmail());
            }

            if(cliente.getFechaNacimiento() != null && !cliente.getFechaNacimiento().toString().isEmpty()){
                clienteUpdate.setFechaNacimiento(cliente.getFechaNacimiento());
            }

            if (cliente.getDireccion() != null && !cliente.getDireccion().isEmpty()) {
                clienteUpdate.setDireccion(cliente.getDireccion());
            }

            return iCliente.save(clienteUpdate);
        }
        return null;
    }

    @Override
    public void deleteCliente(Long id) {
        iCliente.deleteById(id);
    }
}
