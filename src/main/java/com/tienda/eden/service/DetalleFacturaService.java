package com.tienda.eden.service;

import com.tienda.eden.dto.DetalleFacturaRequestDto;
import com.tienda.eden.dto.DetalleFacturaResponseDto;

import java.util.List;

public interface DetalleFacturaService {

    DetalleFacturaResponseDto crear(DetalleFacturaRequestDto dto);

    List<DetalleFacturaResponseDto> listar();

    DetalleFacturaResponseDto buscarPorId(Long id);

    DetalleFacturaResponseDto actualizar(Long id, DetalleFacturaRequestDto dto);

    void eliminar(Long id);
}
