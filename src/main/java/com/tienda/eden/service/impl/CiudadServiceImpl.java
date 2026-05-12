package com.tienda.eden.service.impl;

import com.tienda.eden.dto.CiudadRequestDto;
import com.tienda.eden.dto.CiudadResponseDto;
import com.tienda.eden.entity.Ciudad;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.CiudadMapper;
import com.tienda.eden.repository.CiudadRepository;
import com.tienda.eden.service.CiudadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository repository;

    public CiudadServiceImpl(CiudadRepository repository) {
        this.repository = repository;
    }

    @Override
    public CiudadResponseDto crear(CiudadRequestDto dto) {
        Ciudad entity = CiudadMapper.toEntity(dto);
        Ciudad guardado = repository.save(entity);
        return CiudadMapper.toResponseDto(guardado);
    }

    @Override
    public List<CiudadResponseDto> listar() {
        return repository.findAll().stream().map(CiudadMapper::toResponseDto).toList();
    }

    @Override
    public CiudadResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(CiudadMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Ciudad no encontrado con id: " + id));
    }

    @Override
    public CiudadResponseDto actualizar(Long id, CiudadRequestDto dto) {
        Ciudad entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Ciudad no encontrado con id: " + id));

        CiudadMapper.updateEntity(entity, dto);
        Ciudad actualizado = repository.save(entity);
        return CiudadMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Ciudad entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Ciudad no encontrado con id: " + id));
        repository.delete(entity);
    }
}
