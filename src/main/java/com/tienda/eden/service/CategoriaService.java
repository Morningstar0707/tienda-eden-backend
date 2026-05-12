package com.tienda.eden.service;

import com.tienda.eden.dto.CategoriaRequestDto;
import com.tienda.eden.dto.CategoriaResponseDto;

import java.util.List;

public interface CategoriaService {

    CategoriaResponseDto crear(CategoriaRequestDto dto);

    List<CategoriaResponseDto> listar();

    CategoriaResponseDto buscarPorId(Long id);

    CategoriaResponseDto actualizar(Long id, CategoriaRequestDto dto);

    void eliminar(Long id);
}
