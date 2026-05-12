package com.tienda.eden.service;

import com.tienda.eden.dto.EstadoFacturaRequestDto;
import com.tienda.eden.dto.EstadoFacturaResponseDto;

import java.util.List;

public interface EstadoFacturaService {

    EstadoFacturaResponseDto crear(EstadoFacturaRequestDto dto);

    List<EstadoFacturaResponseDto> listar();

    EstadoFacturaResponseDto buscarPorId(Long id);

    EstadoFacturaResponseDto actualizar(Long id, EstadoFacturaRequestDto dto);

    void eliminar(Long id);
}
