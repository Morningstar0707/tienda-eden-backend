package com.tienda.eden.service.impl;

import com.tienda.eden.dto.MetodoPagoRequestDto;
import com.tienda.eden.dto.MetodoPagoResponseDto;
import com.tienda.eden.entity.MetodoPago;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.MetodoPagoMapper;
import com.tienda.eden.repository.MetodoPagoRepository;
import com.tienda.eden.service.MetodoPagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoRepository repository;

    public MetodoPagoServiceImpl(MetodoPagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public MetodoPagoResponseDto crear(MetodoPagoRequestDto dto) {
        MetodoPago entity = MetodoPagoMapper.toEntity(dto);
        MetodoPago guardado = repository.save(entity);
        return MetodoPagoMapper.toResponseDto(guardado);
    }

    @Override
    public List<MetodoPagoResponseDto> listar() {
        return repository.findAll().stream().map(MetodoPagoMapper::toResponseDto).toList();
    }

    @Override
    public MetodoPagoResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(MetodoPagoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("MetodoPago no encontrado con id: " + id));
    }

    @Override
    public MetodoPagoResponseDto actualizar(Long id, MetodoPagoRequestDto dto) {
        MetodoPago entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("MetodoPago no encontrado con id: " + id));

        MetodoPagoMapper.updateEntity(entity, dto);
        MetodoPago actualizado = repository.save(entity);
        return MetodoPagoMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        MetodoPago entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("MetodoPago no encontrado con id: " + id));
        repository.delete(entity);
    }
}
