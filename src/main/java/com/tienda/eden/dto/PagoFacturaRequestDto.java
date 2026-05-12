package com.tienda.eden.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagoFacturaRequestDto(
        @NotNull(message = "La factura es obligatoria")
        Long idFactura,

        @NotNull(message = "El metodo de pago es obligatorio")
        Long idMetodoPago,

        @NotNull(message = "El monto es obligatorio")
        @DecimalMin(value = "0.00", message = "El monto no puede ser negativo")
        BigDecimal monto,

        String referenciaPago,

        @NotBlank(message = "El estado de pago es obligatorio")
        String estadoPago,

        @NotNull(message = "La fecha de pago es obligatoria")
        LocalDateTime fechaPago
) {
}
