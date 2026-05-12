package com.tienda.eden.service.impl;

import com.tienda.eden.dto.PagoFacturaRequestDto;
import com.tienda.eden.dto.PagoFacturaResponseDto;
import com.tienda.eden.entity.PagoFactura;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.PagoFacturaMapper;
import com.tienda.eden.repository.PagoFacturaRepository;
import com.tienda.eden.service.PagoFacturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoFacturaServiceImpl implements PagoFacturaService {

    private final PagoFacturaRepository repository;

    public PagoFacturaServiceImpl(PagoFacturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PagoFacturaResponseDto crear(PagoFacturaRequestDto dto) {
        PagoFactura entity = PagoFacturaMapper.toEntity(dto);
        PagoFactura guardado = repository.save(entity);
        return PagoFacturaMapper.toResponseDto(guardado);
    }

    @Override
    public List<PagoFacturaResponseDto> listar() {
        return repository.findAll().stream().map(PagoFacturaMapper::toResponseDto).toList();
    }

    @Override
    public PagoFacturaResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(PagoFacturaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("PagoFactura no encontrado con id: " + id));
    }

    @Override
    public PagoFacturaResponseDto actualizar(Long id, PagoFacturaRequestDto dto) {
        PagoFactura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("PagoFactura no encontrado con id: " + id));

        PagoFacturaMapper.updateEntity(entity, dto);
        PagoFactura actualizado = repository.save(entity);
        return PagoFacturaMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        PagoFactura entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("PagoFactura no encontrado con id: " + id));
        repository.delete(entity);
    }
}
