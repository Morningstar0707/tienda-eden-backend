package com.tienda.eden.mapper;

import com.tienda.eden.dto.DireccionRequestDto;
import com.tienda.eden.dto.DireccionResponseDto;
import com.tienda.eden.entity.Direccion;

public class DireccionMapper {

    private DireccionMapper() {
    }

    public static Direccion toEntity(DireccionRequestDto dto) {
        Direccion entity = new Direccion();
        entity.setIdUsuario(dto.idUsuario());
        entity.setIdCiudad(dto.idCiudad());
        entity.setDireccion(dto.direccion());
        entity.setBarrio(dto.barrio());
        entity.setCodigoPostal(dto.codigoPostal());
        entity.setReferencia(dto.referencia());
        return entity;
    }

    public static DireccionResponseDto toResponseDto(Direccion entity) {
        return new DireccionResponseDto(
                entity.getIdDireccion(),
                entity.getIdUsuario(),
                entity.getIdCiudad(),
                entity.getDireccion(),
                entity.getBarrio(),
                entity.getCodigoPostal(),
                entity.getReferencia()
        );
    }

    public static void updateEntity(Direccion entity, DireccionRequestDto dto) {
        entity.setIdUsuario(dto.idUsuario());
        entity.setIdCiudad(dto.idCiudad());
        entity.setDireccion(dto.direccion());
        entity.setBarrio(dto.barrio());
        entity.setCodigoPostal(dto.codigoPostal());
        entity.setReferencia(dto.referencia());
    }
}
