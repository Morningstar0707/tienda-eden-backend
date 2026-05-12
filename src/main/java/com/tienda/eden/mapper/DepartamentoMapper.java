package com.tienda.eden.mapper;

import com.tienda.eden.dto.DepartamentoRequestDto;
import com.tienda.eden.dto.DepartamentoResponseDto;
import com.tienda.eden.entity.Departamento;

public class DepartamentoMapper {

    private DepartamentoMapper() {
    }

    public static Departamento toEntity(DepartamentoRequestDto dto) {
        Departamento entity = new Departamento();
        entity.setNombre(dto.nombre());
        return entity;
    }

    public static DepartamentoResponseDto toResponseDto(Departamento entity) {
        return new DepartamentoResponseDto(
                entity.getIdDepartamento(),
                entity.getNombre()
        );
    }

    public static void updateEntity(Departamento entity, DepartamentoRequestDto dto) {
        entity.setNombre(dto.nombre());
    }
}
