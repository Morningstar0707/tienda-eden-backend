package com.tienda.eden.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DireccionRequestDto(
        @NotNull(message = "El usuario es obligatorio")
        Long idUsuario,

        @NotNull(message = "La ciudad es obligatoria")
        Long idCiudad,

        @NotBlank(message = "La direccion es obligatoria")
        String direccion,

        String barrio,

        String codigoPostal,

        String referencia
) {
}
