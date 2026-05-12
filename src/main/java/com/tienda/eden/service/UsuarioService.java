package com.tienda.eden.service;

import com.tienda.eden.dto.UsuarioRequestDto;
import com.tienda.eden.dto.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDto crear(UsuarioRequestDto dto);

    List<UsuarioResponseDto> listar();

    UsuarioResponseDto buscarPorId(Long id);

    UsuarioResponseDto actualizar(Long id, UsuarioRequestDto dto);

    void eliminar(Long id);
}
