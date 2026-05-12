package com.tienda.eden.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagoFacturaResponseDto(
        Long idPago,
        Long idFactura,
        Long idMetodoPago,
        BigDecimal monto,
        String referenciaPago,
        String estadoPago,
        LocalDateTime fechaPago
) {
}
