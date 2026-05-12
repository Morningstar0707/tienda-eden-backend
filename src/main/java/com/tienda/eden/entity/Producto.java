package com.tienda.eden.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "id_categoria")
    private Long idCategoria;

    public Producto() {
    }

    public Producto(Long idProducto, String nombre, String descripcion, BigDecimal precio, Integer stock, String imagenUrl, Boolean activo, Long idCategoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagenUrl = imagenUrl;
        this.activo = activo;
        this.idCategoria = idCategoria;
    }

    public Long getIdProducto() { return idProducto; }
    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }
}
