package com.tienda.eden.service;

import com.tienda.eden.dto.FacturaRequestDto;
import com.tienda.eden.dto.FacturaResponseDto;

import java.util.List;

public interface FacturaService {

    FacturaResponseDto crear(FacturaRequestDto dto);

    List<FacturaResponseDto> listar();

    FacturaResponseDto buscarPorId(Long id);

    FacturaResponseDto actualizar(Long id, FacturaRequestDto dto);

    void eliminar(Long id);
}
