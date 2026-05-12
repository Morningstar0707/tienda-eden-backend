package com.tienda.eden.service.impl;

import com.tienda.eden.dto.DetalleFacturaRequestDto;
import com.tienda.eden.dto.DetalleFacturaResponseDto;
import com.tienda.eden.entity.DetalleFactura;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.DetalleFacturaMapper;
import com.tienda.eden.repository.DetalleFacturaRepository;
import com.tienda.eden.service.DetalleFacturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    private final DetalleFacturaRepository repository;

    public DetalleFacturaServiceImpl(DetalleFacturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public DetalleFacturaResponseDto crear(DetalleFacturaRequestDto dto) {
        DetalleFactura entity = DetalleFacturaMapper.toEntity(dto);
        DetalleFactura guardado = repository.save(entity);
        return DetalleFacturaMapper.toResponseDto(guardado);
    }

    @Override
    public List<DetalleFacturaResponseDto> listar() {
        return repository.findAll().stream().map(DetalleFacturaMapper::toResponseDto).toList();
    }

    @Override
    public DetalleFacturaResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(DetalleFacturaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("DetalleFactura no encontrado con id: " + id));
    }

    @Override
    public DetalleFacturaResponseDto actualizar(Long id, DetalleFacturaRequestDto dto) {
        DetalleFactura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("DetalleFactura no encontrado con id: " + id));

        DetalleFacturaMapper.updateEntity(entity, dto);
        DetalleFactura actualizado = repository.save(entity);
        return DetalleFacturaMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        DetalleFactura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("DetalleFactura no encontrado con id: " + id));
        repository.delete(entity);
    }
}
