package com.tienda.eden.service;

import com.tienda.eden.dto.ProductoRequestDto;
import com.tienda.eden.dto.ProductoResponseDto;

import java.util.List;

public interface ProductoService {

    ProductoResponseDto crear(ProductoRequestDto dto);

    List<ProductoResponseDto> listar();

    ProductoResponseDto buscarPorId(Long id);

    ProductoResponseDto actualizar(Long id, ProductoRequestDto dto);

    void eliminar(Long id);
}
