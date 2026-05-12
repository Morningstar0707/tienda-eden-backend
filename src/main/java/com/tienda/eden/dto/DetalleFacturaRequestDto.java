package com.tienda.eden.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record DetalleFacturaRequestDto(
        @NotNull(message = "La factura es obligatoria")
        Long idFactura,

        Long idProducto,

        @NotBlank(message = "El nombre del producto es obligatorio")
        String nombreProducto,

        @NotNull(message = "La cantidad es obligatoria")
        @Min(value = 1, message = "La cantidad debe ser mayor a 0")
        Integer cantidad,

        @NotNull(message = "El precio unitario es obligatorio")
        @DecimalMin(value = "0.00", message = "El precio unitario no puede ser negativo")
        BigDecimal precioUnitario,

        @NotNull(message = "El subtotal es obligatorio")
        @DecimalMin(value = "0.00", message = "El subtotal no puede ser negativo")
        BigDecimal subtotal
) {
}
