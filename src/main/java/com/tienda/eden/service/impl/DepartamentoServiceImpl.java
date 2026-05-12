package com.tienda.eden.service.impl;

import com.tienda.eden.dto.DepartamentoRequestDto;
import com.tienda.eden.dto.DepartamentoResponseDto;
import com.tienda.eden.entity.Departamento;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.DepartamentoMapper;
import com.tienda.eden.repository.DepartamentoRepository;
import com.tienda.eden.service.DepartamentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository repository;

    public DepartamentoServiceImpl(DepartamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepartamentoResponseDto crear(DepartamentoRequestDto dto) {
        Departamento entity = DepartamentoMapper.toEntity(dto);
        Departamento guardado = repository.save(entity);
        return DepartamentoMapper.toResponseDto(guardado);
    }

    @Override
    public List<DepartamentoResponseDto> listar() {
        return repository.findAll().stream().map(DepartamentoMapper::toResponseDto).toList();
    }

    @Override
    public DepartamentoResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(DepartamentoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Departamento no encontrado con id: " + id));
    }

    @Override
    public DepartamentoResponseDto actualizar(Long id, DepartamentoRequestDto dto) {
        Departamento entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Departamento no encontrado con id: " + id));

        DepartamentoMapper.updateEntity(entity, dto);
        Departamento actualizado = repository.save(entity);
        return DepartamentoMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Departamento entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Departamento no encontrado con id: " + id));
        repository.delete(entity);
    }
}
