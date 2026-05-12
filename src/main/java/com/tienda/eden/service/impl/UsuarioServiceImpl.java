package com.tienda.eden.service.impl;

import com.tienda.eden.dto.UsuarioRequestDto;
import com.tienda.eden.dto.UsuarioResponseDto;
import com.tienda.eden.entity.Usuario;
import com.tienda.eden.exception.RecursoNoEncontradoException;
import com.tienda.eden.mapper.UsuarioMapper;
import com.tienda.eden.repository.UsuarioRepository;
import com.tienda.eden.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioResponseDto crear(UsuarioRequestDto dto) {
        Usuario entity = UsuarioMapper.toEntity(dto);
        Usuario guardado = repository.save(entity);
        return UsuarioMapper.toResponseDto(guardado);
    }

    @Override
    public List<UsuarioResponseDto> listar() {
        return repository.findAll().stream().map(UsuarioMapper::toResponseDto).toList();
    }

    @Override
    public UsuarioResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(UsuarioMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con id: " + id));
    }

    @Override
    public UsuarioResponseDto actualizar(Long id, UsuarioRequestDto dto) {
        Usuario entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con id: " + id));

        UsuarioMapper.updateEntity(entity, dto);
        Usuario actualizado = repository.save(entity);
        return UsuarioMapper.toResponseDto(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Usuario entity = repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con id: " + id));
        repository.delete(entity);
    }
}
