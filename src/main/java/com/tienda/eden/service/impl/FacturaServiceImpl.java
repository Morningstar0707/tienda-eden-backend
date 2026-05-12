package com.tienda.eden.service.impl;

import com.tienda.eden.dto.FacturaRequestDto;
import com.tienda.eden.dto.FacturaResponseDto;
import com.tienda.eden.entity.Factura;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.FacturaMapper;
import com.tienda.eden.repository.FacturaRepository;
import com.tienda.eden.service.FacturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository repository;

    public FacturaServiceImpl(FacturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public FacturaResponseDto crear(FacturaRequestDto dto) {
        Factura entity = FacturaMapper.toEntity(dto);
        Factura guardado = repository.save(entity);
        return FacturaMapper.toResponseDto(guardado);
    }

    @Override
    public List<FacturaResponseDto> listar() {
        return repository.findAll().stream().map(FacturaMapper::toResponseDto).toList();
    }

    @Override
    public FacturaResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(FacturaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Factura no encontrado con id: " + id));
    }

    @Override
    public FacturaResponseDto actualizar(Long id, FacturaRequestDto dto) {
        Factura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Factura no encontrado con id: " + id));

        FacturaMapper.updateEntity(entity, dto);
        Factura actualizado = repository.save(entity);
        return FacturaMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Factura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Factura no encontrado con id: " + id));
        repository.delete(entity);
    }
}
