package com.tienda.eden.mapper;

import com.tienda.eden.dto.MetodoPagoRequestDto;
import com.tienda.eden.dto.MetodoPagoResponseDto;
import com.tienda.eden.entity.MetodoPago;

public class MetodoPagoMapper {

    private MetodoPagoMapper() {
    }

    public static MetodoPago toEntity(MetodoPagoRequestDto dto) {
        MetodoPago entity = new MetodoPago();
        entity.setNombre(dto.nombre());
        entity.setActivo(dto.activo());
        return entity;
    }

    public static MetodoPagoResponseDto toResponseDto(MetodoPago entity) {
        return new MetodoPagoResponseDto(
                entity.getIdMetodoPago(),
                entity.getNombre(),
                entity.getActivo()
        );
    }

    public static void updateEntity(MetodoPago entity, MetodoPagoRequestDto dto) {
        entity.setNombre(dto.nombre());
        entity.setActivo(dto.activo());
    }
}
