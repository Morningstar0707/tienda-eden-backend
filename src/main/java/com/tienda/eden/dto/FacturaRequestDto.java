package com.tienda.eden.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FacturaRequestDto(
        @NotNull(message = "El usuario es obligatorio")
        Long idUsuario,

        @NotNull(message = "El estado de factura es obligatorio")
        Long idEstadoFactura,

        @NotNull(message = "La fecha de factura es obligatoria")
        LocalDateTime fechaFactura,

        @NotBlank(message = "El nombre del cliente es obligatorio")
        String nombreCliente,

        String telefonoCliente,

        @NotBlank(message = "La direccion de envio es obligatoria")
        String direccionEnvio,

        String barrioEnvio,

        String ciudadEnvio,

        String departamentoEnvio,

        @NotNull(message = "El subtotal es obligatorio")
        @DecimalMin(value = "0.00", message = "El subtotal no puede ser negativo")
        BigDecimal subtotal,

        @NotNull(message = "El IVA es obligatorio")
        @DecimalMin(value = "0.00", message = "El IVA no puede ser negativo")
        BigDecimal iva,

        String notasFactura
) {
}
