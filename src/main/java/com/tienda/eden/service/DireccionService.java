package com.tienda.eden.service;

import com.tienda.eden.dto.DireccionRequestDto;
import com.tienda.eden.dto.DireccionResponseDto;

import java.util.List;

public interface DireccionService {

    DireccionResponseDto crear(DireccionRequestDto dto);

    List<DireccionResponseDto> listar();

    DireccionResponseDto buscarPorId(Long id);

    DireccionResponseDto actualizar(Long id, DireccionRequestDto dto);

    void eliminar(Long id);
}
