package com.tienda.eden.dto;

import jakarta.validation.constraints.NotBlank;

public record DepartamentoRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre
) {
}
