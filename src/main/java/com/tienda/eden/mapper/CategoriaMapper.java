package com.tienda.eden.mapper;

import com.tienda.eden.dto.CategoriaRequestDto;
import com.tienda.eden.dto.CategoriaResponseDto;
import com.tienda.eden.entity.Categoria;

public class CategoriaMapper {

    private CategoriaMapper() {
    }

    public static Categoria toEntity(CategoriaRequestDto dto) {
        Categoria entity = new Categoria();
        entity.setNombre(dto.nombre());
        return entity;
    }

    public static CategoriaResponseDto toResponseDto(Categoria entity) {
        return new CategoriaResponseDto(
                entity.getIdCategoria(),
                entity.getNombre()
        );
    }

    public static void updateEntity(Categoria entity, CategoriaRequestDto dto) {
        entity.setNombre(dto.nombre());
    }
}
