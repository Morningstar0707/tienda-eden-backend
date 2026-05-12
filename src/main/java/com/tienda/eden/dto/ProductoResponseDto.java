package com.tienda.eden.dto;

import java.math.BigDecimal;

public record ProductoResponseDto(
        Long idProducto,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Integer stock,
        String imagenUrl,
        Boolean activo,
        Long idCategoria
) {
}
