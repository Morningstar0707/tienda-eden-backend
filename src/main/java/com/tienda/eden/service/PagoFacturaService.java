package com.tienda.eden.service;

import com.tienda.eden.dto.PagoFacturaRequestDto;
import com.tienda.eden.dto.PagoFacturaResponseDto;

import java.util.List;

public interface PagoFacturaService {

    PagoFacturaResponseDto crear(PagoFacturaRequestDto dto);

    List<PagoFacturaResponseDto> listar();

    PagoFacturaResponseDto buscarPorId(Long id);

    PagoFacturaResponseDto actualizar(Long id, PagoFacturaRequestDto dto);

    void eliminar(Long id);
}
