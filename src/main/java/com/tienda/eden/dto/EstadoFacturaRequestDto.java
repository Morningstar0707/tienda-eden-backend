package com.tienda.eden.dto;

import jakarta.validation.constraints.NotBlank;

public record EstadoFacturaRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre
) {
}
