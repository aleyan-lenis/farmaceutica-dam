package com.example.sistema_farmaceutico.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "IdProducto")
    private List<Producto> productos;
    @ManyToOne
    private Cliente cliente_id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy",timezone = "America/Guayaquil")
    private Date fecha;
    private int numero_factura;
}
