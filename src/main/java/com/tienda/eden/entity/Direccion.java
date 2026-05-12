package com.tienda.eden.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "DIRECCIONES")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long idDireccion;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_ciudad", nullable = false)
    private Long idCiudad;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Column(name = "barrio", length = 100)
    private String barrio;

    @Column(name = "codigo_postal", length = 20)
    private String codigoPostal;

    @Column(name = "referencia")
    private String referencia;

    public Direccion() {
    }

    public Direccion(Long idDireccion, Long idUsuario, Long idCiudad, String direccion, String barrio, String codigoPostal, String referencia) {
        this.idDireccion = idDireccion;
        this.idUsuario = idUsuario;
        this.idCiudad = idCiudad;
        this.direccion = direccion;
        this.barrio = barrio;
        this.codigoPostal = codigoPostal;
        this.referencia = referencia;
    }

    public Long getIdDireccion() { return idDireccion; }
    public void setIdDireccion(Long idDireccion) { this.idDireccion = idDireccion; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public Long getIdCiudad() { return idCiudad; }
    public void setIdCiudad(Long idCiudad) { this.idCiudad = idCiudad; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getBarrio() { return barrio; }
    public void setBarrio(String barrio) { this.barrio = barrio; }
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
}
