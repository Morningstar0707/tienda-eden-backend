package com.tienda.eden.service;

import com.tienda.eden.dto.DepartamentoRequestDto;
import com.tienda.eden.dto.DepartamentoResponseDto;

import java.util.List;

public interface DepartamentoService {

    DepartamentoResponseDto crear(DepartamentoRequestDto dto);

    List<DepartamentoResponseDto> listar();

    DepartamentoResponseDto buscarPorId(Long id);

    DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto dto);

    void eliminar(Long id);
}
