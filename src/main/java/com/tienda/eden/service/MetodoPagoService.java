package com.tienda.eden.service;

import com.tienda.eden.dto.MetodoPagoRequestDto;
import com.tienda.eden.dto.MetodoPagoResponseDto;

import java.util.List;

public interface MetodoPagoService {

    MetodoPagoResponseDto crear(MetodoPagoRequestDto dto);

    List<MetodoPagoResponseDto> listar();

    MetodoPagoResponseDto buscarPorId(Long id);

    MetodoPagoResponseDto actualizar(Long id, MetodoPagoRequestDto dto);

    void eliminar(Long id);
}
