package com.tienda.eden.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MetodoPagoRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotNull(message = "El estado activo es obligatorio")
        Boolean activo
) {
}
