package com.tienda.eden.mapper;

import com.tienda.eden.dto.UsuarioRequestDto;
import com.tienda.eden.dto.UsuarioResponseDto;
import com.tienda.eden.entity.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario toEntity(UsuarioRequestDto dto) {
        Usuario entity = new Usuario();
        entity.setNombre(dto.nombre());
        entity.setEmail(dto.email());
        entity.setTelefono(dto.telefono());
        entity.setContrasenaHash(dto.contrasenaHash());
        return entity;
    }

    public static UsuarioResponseDto toResponseDto(Usuario entity) {
        return new UsuarioResponseDto(
                entity.getIdUsuario(),
                entity.getNombre(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getContrasenaHash()
        );
    }

    public static void updateEntity(Usuario entity, UsuarioRequestDto dto) {
        entity.setNombre(dto.nombre());
        entity.setEmail(dto.email());
        entity.setTelefono(dto.telefono());
        entity.setContrasenaHash(dto.contrasenaHash());
    }
}
