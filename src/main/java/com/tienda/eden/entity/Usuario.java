package com.tienda.eden.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "contrasena_hash", nullable = false, length = 255)
    private String contrasenaHash;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String email, String telefono, String contrasenaHash) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasenaHash = contrasenaHash;
    }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getContrasenaHash() { return contrasenaHash; }
    public void setContrasenaHash(String contrasenaHash) { this.contrasenaHash = contrasenaHash; }
}
