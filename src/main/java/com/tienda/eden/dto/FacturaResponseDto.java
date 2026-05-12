package com.tienda.eden.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FacturaResponseDto(
        Long idFactura,
        Long idUsuario,
        Long idEstadoFactura,
        LocalDateTime fechaFactura,
        String nombreCliente,
        String telefonoCliente,
        String direccionEnvio,
        String barrioEnvio,
        String ciudadEnvio,
        String departamentoEnvio,
        BigDecimal subtotal,
        BigDecimal iva,
        String notasFactura
) {
}
