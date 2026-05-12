package com.tienda.eden.dto;



public record CiudadResponseDto(
        Long idCiudad,
        String nombre,
        Long idDepartamento
) {
}
