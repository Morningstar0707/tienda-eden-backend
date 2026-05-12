package com.tienda.eden.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "METODOS_PAGO")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_pago")
    private Long idMetodoPago;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    public MetodoPago() {
    }

    public MetodoPago(Long idMetodoPago, String nombre, Boolean activo) {
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Long getIdMetodoPago() { return idMetodoPago; }
    public void setIdMetodoPago(Long idMetodoPago) { this.idMetodoPago = idMetodoPago; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
