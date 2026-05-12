package com.tienda.eden.dto;



public record UsuarioResponseDto(
        Long idUsuario,
        String nombre,
        String email,
        String telefono,
        String contrasenaHash
) {
}
