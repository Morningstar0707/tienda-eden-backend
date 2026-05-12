package com.tienda.eden.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "FACTURAS")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_estado_factura", nullable = false)
    private Long idEstadoFactura;

    @Column(name = "fecha_factura", nullable = false)
    private LocalDateTime fechaFactura;

    @Column(name = "nombre_cliente", nullable = false, length = 150)
    private String nombreCliente;

    @Column(name = "telefono_cliente", length = 20)
    private String telefonoCliente;

    @Column(name = "direccion_envio", nullable = false, length = 255)
    private String direccionEnvio;

    @Column(name = "barrio_envio", length = 100)
    private String barrioEnvio;

    @Column(name = "ciudad_envio", length = 100)
    private String ciudadEnvio;

    @Column(name = "departamento_envio", length = 100)
    private String departamentoEnvio;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "IVA", nullable = false)
    private BigDecimal iva;

    @Column(name = "notas_factura")
    private String notasFactura;

    public Factura() {
    }

    public Factura(Long idFactura, Long idUsuario, Long idEstadoFactura, LocalDateTime fechaFactura, String nombreCliente, String telefonoCliente, String direccionEnvio, String barrioEnvio, String ciudadEnvio, String departamentoEnvio, BigDecimal subtotal, BigDecimal iva, String notasFactura) {
        this.idFactura = idFactura;
        this.idUsuario = idUsuario;
        this.idEstadoFactura = idEstadoFactura;
        this.fechaFactura = fechaFactura;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.direccionEnvio = direccionEnvio;
        this.barrioEnvio = barrioEnvio;
        this.ciudadEnvio = ciudadEnvio;
        this.departamentoEnvio = departamentoEnvio;
        this.subtotal = subtotal;
        this.iva = iva;
        this.notasFactura = notasFactura;
    }

    public Long getIdFactura() { return idFactura; }
    public void setIdFactura(Long idFactura) { this.idFactura = idFactura; }
    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public Long getIdEstadoFactura() { return idEstadoFactura; }
    public void setIdEstadoFactura(Long idEstadoFactura) { this.idEstadoFactura = idEstadoFactura; }
    public LocalDateTime getFechaFactura() { return fechaFactura; }
    public void setFechaFactura(LocalDateTime fechaFactura) { this.fechaFactura = fechaFactura; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }
    public String getDireccionEnvio() { return direccionEnvio; }
    public void setDireccionEnvio(String direccionEnvio) { this.direccionEnvio = direccionEnvio; }
    public String getBarrioEnvio() { return barrioEnvio; }
    public void setBarrioEnvio(String barrioEnvio) { this.barrioEnvio = barrioEnvio; }
    public String getCiudadEnvio() { return ciudadEnvio; }
    public void setCiudadEnvio(String ciudadEnvio) { this.ciudadEnvio = ciudadEnvio; }
    public String getDepartamentoEnvio() { return departamentoEnvio; }
    public void setDepartamentoEnvio(String departamentoEnvio) { this.departamentoEnvio = departamentoEnvio; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public BigDecimal getIva() { return iva; }
    public void setIva(BigDecimal iva) { this.iva = iva; }
    public String getNotasFactura() { return notasFactura; }
    public void setNotasFactura(String notasFactura) { this.notasFactura = notasFactura; }
}
