package com.tienda.eden.service.impl;

import com.tienda.eden.dto.EstadoFacturaRequestDto;
import com.tienda.eden.dto.EstadoFacturaResponseDto;
import com.tienda.eden.entity.EstadoFactura;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.EstadoFacturaMapper;
import com.tienda.eden.repository.EstadoFacturaRepository;
import com.tienda.eden.service.EstadoFacturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoFacturaServiceImpl implements EstadoFacturaService {

    private final EstadoFacturaRepository repository;

    public EstadoFacturaServiceImpl(EstadoFacturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public EstadoFacturaResponseDto crear(EstadoFacturaRequestDto dto) {
        EstadoFactura entity = EstadoFacturaMapper.toEntity(dto);
        EstadoFactura guardado = repository.save(entity);
        return EstadoFacturaMapper.toResponseDto(guardado);
    }

    @Override
    public List<EstadoFacturaResponseDto> listar() {
        return repository.findAll().stream().map(EstadoFacturaMapper::toResponseDto).toList();
    }

    @Override
    public EstadoFacturaResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(EstadoFacturaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("EstadoFactura no encontrado con id: " + id));
    }

    @Override
    public EstadoFacturaResponseDto actualizar(Long id, EstadoFacturaRequestDto dto) {
        EstadoFactura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("EstadoFactura no encontrado con id: " + id));

        EstadoFacturaMapper.updateEntity(entity, dto);
        EstadoFactura actualizado = repository.save(entity);
        return EstadoFacturaMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        EstadoFactura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("EstadoFactura no encontrado con id: " + id));
        repository.delete(entity);
    }
}
