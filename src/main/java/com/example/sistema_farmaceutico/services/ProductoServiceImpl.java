package com.example.sistema_farmaceutico.services;

import com.example.sistema_farmaceutico.models.Producto;
import com.example.sistema_farmaceutico.repository.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private IProducto iProducto;

    @Override
    public List<Producto> getProductos() {
        return iProducto.findAll();
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        return iProducto.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return iProducto.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        Optional<Producto> productoOptional = iProducto.findById(id);
        if (productoOptional.isPresent()) {
            Producto p = productoOptional.get();
            if(!p.getDescripcionProducto().isEmpty()){
                p.setDescripcionProducto(producto.getDescripcionProducto());
            }
            if(!p.getNombreProducto().isEmpty()){
                p.setNombreProducto(producto.getNombreProducto());
            }
            if(!String.valueOf(p.getCantidadStockProducto()).isEmpty()){
                p.setCantidadStockProducto(producto.getCantidadStockProducto());
            }
            if(p.getCategoria().getIdCategoria().equals(producto.getCategoria().getIdCategoria())){
                p.setCategoria(producto.getCategoria());
            }
            return iProducto.save(p);
        }
        return null;
    }

    @Override
    public void deleteProducto(Long id) {
        iProducto.deleteById(id);
    }
}
