package com.tienda.eden.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CiudadRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotNull(message = "El departamento es obligatorio")
        Long idDepartamento
) {
}
