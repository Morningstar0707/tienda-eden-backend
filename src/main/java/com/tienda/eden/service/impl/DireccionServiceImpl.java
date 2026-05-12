package com.tienda.eden.service.impl;

import com.tienda.eden.dto.DireccionRequestDto;
import com.tienda.eden.dto.DireccionResponseDto;
import com.tienda.eden.entity.Direccion;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.DireccionMapper;
import com.tienda.eden.repository.DireccionRepository;
import com.tienda.eden.service.DireccionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository repository;

    public DireccionServiceImpl(DireccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public DireccionResponseDto crear(DireccionRequestDto dto) {
        Direccion entity = DireccionMapper.toEntity(dto);
        Direccion guardado = repository.save(entity);
        return DireccionMapper.toResponseDto(guardado);
    }

    @Override
    public List<DireccionResponseDto> listar() {
        return repository.findAll().stream().map(DireccionMapper::toResponseDto).toList();
    }

    @Override
    public DireccionResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(DireccionMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Direccion no encontrado con id: " + id));
    }

    @Override
    public DireccionResponseDto actualizar(Long id, DireccionRequestDto dto) {
        Direccion entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Direccion no encontrado con id: " + id));

        DireccionMapper.updateEntity(entity, dto);
        Direccion actualizado = repository.save(entity);
        return DireccionMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Direccion entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Direccion no encontrado con id: " + id));
        repository.delete(entity);
    }
}
