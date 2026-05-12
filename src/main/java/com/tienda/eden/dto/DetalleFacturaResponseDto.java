package com.tienda.eden.dto;

import java.math.BigDecimal;

public record DetalleFacturaResponseDto(
        Long idDetalle,
        Long idFactura,
        Long idProducto,
        String nombreProducto,
        Integer cantidad,
        BigDecimal precioUnitario,
        BigDecimal subtotal
) {
}
