package com.tienda.eden.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    public Departamento() {
    }

    public Departamento(Long idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public Long getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(Long idDepartamento) { this.idDepartamento = idDepartamento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
