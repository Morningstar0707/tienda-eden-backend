package com.tienda.eden.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "CIUDADES")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long idCiudad;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "id_departamento", nullable = false)
    private Long idDepartamento;

    public Ciudad() {
    }

    public Ciudad(Long idCiudad, String nombre, Long idDepartamento) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
    }

    public Long getIdCiudad() { return idCiudad; }
    public void setIdCiudad(Long idCiudad) { this.idCiudad = idCiudad; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Long getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(Long idDepartamento) { this.idDepartamento = idDepartamento; }
}
