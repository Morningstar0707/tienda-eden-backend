package com.tienda.eden.service.impl;

import com.tienda.eden.dto.ProductoRequestDto;
import com.tienda.eden.dto.ProductoResponseDto;
import com.tienda.eden.entity.Producto;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.ProductoMapper;
import com.tienda.eden.repository.ProductoRepository;
import com.tienda.eden.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductoResponseDto crear(ProductoRequestDto dto) {
        Producto entity = ProductoMapper.toEntity(dto);
        Producto guardado = repository.save(entity);
        return ProductoMapper.toResponseDto(guardado);
    }

    @Override
    public List<ProductoResponseDto> listar() {
        return repository.findAll().stream().map(ProductoMapper::toResponseDto).toList();
    }

    @Override
    public ProductoResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(ProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id: " + id));
    }

    @Override
    public ProductoResponseDto actualizar(Long id, ProductoRequestDto dto) {
        Producto entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id: " + id));

        ProductoMapper.updateEntity(entity, dto);
        Producto actualizado = repository.save(entity);
        return ProductoMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Producto entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id: " + id));
        repository.delete(entity);
    }
}
