package com.tienda.eden.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DETALLES_FACTURA")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @Column(name = "id_factura", nullable = false)
    private Long idFactura;

    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre_producto", nullable = false, length = 150)
    private String nombreProducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    public DetalleFactura() {
    }

    public DetalleFactura(Long idDetalle, Long idFactura, Long idProducto, String nombreProducto, Integer cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.idDetalle = idDetalle;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public Long getIdDetalle() { return idDetalle; }
    public void setIdDetalle(Long idDetalle) { this.idDetalle = idDetalle; }
    public Long getIdFactura() { return idFactura; }
    public void setIdFactura(Long idFactura) { this.idFactura = idFactura; }
    public Long getIdProducto() { return idProducto; }
    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }
    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
