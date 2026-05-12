package com.tienda.eden.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo no es valido")
        String email,

        String telefono,

        @NotBlank(message = "La contrasena es obligatoria")
        String contrasenaHash
) {
}
