package com.tienda.eden.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAGOS_FACTURA")
public class PagoFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long idPago;

    @Column(name = "id_factura", nullable = false)
    private Long idFactura;

    @Column(name = "id_metodo_pago", nullable = false)
    private Long idMetodoPago;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "referencia_pago", length = 150)
    private String referenciaPago;

    @Column(name = "estado_pago", nullable = false)
    private String estadoPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime fechaPago;

    public PagoFactura() {
    }

    public PagoFactura(Long idPago, Long idFactura, Long idMetodoPago, BigDecimal monto, String referenciaPago, String estadoPago, LocalDateTime fechaPago) {
        this.idPago = idPago;
        this.idFactura = idFactura;
        this.idMetodoPago = idMetodoPago;
        this.monto = monto;
        this.referenciaPago = referenciaPago;
        this.estadoPago = estadoPago;
        this.fechaPago = fechaPago;
    }

    public Long getIdPago() { return idPago; }
    public void setIdPago(Long idPago) { this.idPago = idPago; }
    public Long getIdFactura() { return idFactura; }
    public void setIdFactura(Long idFactura) { this.idFactura = idFactura; }
    public Long getIdMetodoPago() { return idMetodoPago; }
    public void setIdMetodoPago(Long idMetodoPago) { this.idMetodoPago = idMetodoPago; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public String getReferenciaPago() { return referenciaPago; }
    public void setReferenciaPago(String referenciaPago) { this.referenciaPago = referenciaPago; }
    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }
    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
}
