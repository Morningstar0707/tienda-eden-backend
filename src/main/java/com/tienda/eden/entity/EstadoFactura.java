package com.tienda.eden.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "ESTADOS_FACTURA")
public class EstadoFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_factura")
    private Long idEstadoFactura;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    public EstadoFactura() {
    }

    public EstadoFactura(Long idEstadoFactura, String nombre) {
        this.idEstadoFactura = idEstadoFactura;
        this.nombre = nombre;
    }

    public Long getIdEstadoFactura() { return idEstadoFactura; }
    public void setIdEstadoFactura(Long idEstadoFactura) { this.idEstadoFactura = idEstadoFactura; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
