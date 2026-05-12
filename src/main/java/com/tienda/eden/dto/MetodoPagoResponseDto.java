package com.tienda.eden.dto;



public record MetodoPagoResponseDto(
        Long idMetodoPago,
        String nombre,
        Boolean activo
) {
}
