package com.tienda.eden.service;

import com.tienda.eden.dto.CiudadRequestDto;
import com.tienda.eden.dto.CiudadResponseDto;

import java.util.List;

public interface CiudadService {

    CiudadResponseDto crear(CiudadRequestDto dto);

    List<CiudadResponseDto> listar();

    CiudadResponseDto buscarPorId(Long id);

    CiudadResponseDto actualizar(Long id, CiudadRequestDto dto);

    void eliminar(Long id);
}
