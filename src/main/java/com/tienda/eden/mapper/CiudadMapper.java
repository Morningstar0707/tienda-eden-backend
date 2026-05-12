package com.tienda.eden.mapper;

import com.tienda.eden.dto.CiudadRequestDto;
import com.tienda.eden.dto.CiudadResponseDto;
import com.tienda.eden.entity.Ciudad;

public class CiudadMapper {

    private CiudadMapper() {
    }

    public static Ciudad toEntity(CiudadRequestDto dto) {
        Ciudad entity = new Ciudad();
        entity.setNombre(dto.nombre());
        entity.setIdDepartamento(dto.idDepartamento());
        return entity;
    }

    public static CiudadResponseDto toResponseDto(Ciudad entity) {
        return new CiudadResponseDto(
                entity.getIdCiudad(),
                entity.getNombre(),
                entity.getIdDepartamento()
        );
    }

    public static void updateEntity(Ciudad entity, CiudadRequestDto dto) {
        entity.setNombre(dto.nombre());
        entity.setIdDepartamento(dto.idDepartamento());
    }
}
