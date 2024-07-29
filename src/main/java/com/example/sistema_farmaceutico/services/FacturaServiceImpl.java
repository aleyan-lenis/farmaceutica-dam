package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Factura;
import com.example.sistema_farmaceutico.models.Producto;
import com.example.sistema_farmaceutico.repository.IFactura;
import com.example.sistema_farmaceutico.repository.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private IFactura iFactura;

    @Autowired
    private IProducto iProducto;

    @Override
    public List<Factura> getFacturas() {
        return iFactura.findAll();
    }

    @Override
    public Optional<Factura> getFactura(Long id) {
        return iFactura.findById(id);
    }

    @Override
    public Factura addFactura(Factura factura) {
        // Recupera y asigna los productos gestionados
        List<Producto> productos = factura.getProductos();
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            Optional<Producto> productoOptional = iProducto.findById(producto.getIdProducto());
            if (productoOptional.isPresent()) {
                productos.set(i, productoOptional.get());
            } else {
                // Maneja el caso donde el producto no existe
                throw new RuntimeException("Producto no encontrado: " + producto.getIdProducto());
            }
        }
        factura.setProductos(productos);

        return iFactura.save(factura);
    }

    @Override
    public Factura updateFactura(Long id, Factura factura) {
        Optional<Factura> f = iFactura.findById(id);
        if (f.isPresent()) {
            Factura facturaActual = f.get();
            if (factura.getProductos() != null && !factura.getProductos().isEmpty()) {
                List<Producto> productos = factura.getProductos();
                for (int i = 0; i < productos.size(); i++) {
                    Producto producto = productos.get(i);
                    Optional<Producto> productoOptional = iProducto.findById(producto.getIdProducto());
                    if (productoOptional.isPresent()) {
                        productos.set(i, productoOptional.get());
                    } else {
                        throw new RuntimeException("Producto no encontrado: " + producto.getIdProducto());
                    }
                }
                facturaActual.setProductos(productos);
            }
            return iFactura.save(facturaActual);
        }
        return null;
    }

    @Override
    public void deleteFactura(Long id) {
        iFactura.deleteById(id);
    }
}
