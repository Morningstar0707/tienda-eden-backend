package com.tienda.eden.dto;



public record DireccionResponseDto(
        Long idDireccion,
        Long idUsuario,
        Long idCiudad,
        String direccion,
        String barrio,
        String codigoPostal,
        String referencia
) {
}
