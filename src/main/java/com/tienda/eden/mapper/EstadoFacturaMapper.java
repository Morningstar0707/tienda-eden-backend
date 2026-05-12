package com.tienda.eden.mapper;

import com.tienda.eden.dto.EstadoFacturaRequestDto;
import com.tienda.eden.dto.EstadoFacturaResponseDto;
import com.tienda.eden.entity.EstadoFactura;

public class EstadoFacturaMapper {

    private EstadoFacturaMapper() {
    }

    public static EstadoFactura toEntity(EstadoFacturaRequestDto dto) {
        EstadoFactura entity = new EstadoFactura();
        entity.setNombre(dto.nombre());
        return entity;
    }

    public static EstadoFacturaResponseDto toResponseDto(EstadoFactura entity) {
        return new EstadoFacturaResponseDto(
                entity.getIdEstadoFactura(),
                entity.getNombre()
        );
    }

    public static void updateEntity(EstadoFactura entity, EstadoFacturaRequestDto dto) {
        entity.setNombre(dto.nombre());
    }
}
