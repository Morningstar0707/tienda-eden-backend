package com.tienda.eden.service.impl;

import com.tienda.eden.dto.CategoriaRequestDto;
import com.tienda.eden.dto.CategoriaResponseDto;
import com.tienda.eden.entity.Categoria;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.CategoriaMapper;
import com.tienda.eden.repository.CategoriaRepository;
import com.tienda.eden.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoriaResponseDto crear(CategoriaRequestDto dto) {
        Categoria entity = CategoriaMapper.toEntity(dto);
        Categoria guardado = repository.save(entity);
        return CategoriaMapper.toResponseDto(guardado);
    }

    @Override
    public List<CategoriaResponseDto> listar() {
        return repository.findAll().stream().map(CategoriaMapper::toResponseDto).toList();
    }

    @Override
    public CategoriaResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(CategoriaMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrado con id: " + id));
    }

    @Override
    public CategoriaResponseDto actualizar(Long id, CategoriaRequestDto dto) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrado con id: " + id));

        CategoriaMapper.updateEntity(entity, dto);
        Categoria actualizado = repository.save(entity);
        return CategoriaMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrado con id: " + id));
        repository.delete(entity);
    }
}
