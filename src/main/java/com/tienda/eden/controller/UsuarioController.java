package com.tienda.eden.controller;

import com.tienda.eden.dto.UsuarioRequestDto;
import com.tienda.eden.dto.UsuarioResponseDto;
import com.tienda.eden.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDto crear(@Valid @RequestBody UsuarioRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<UsuarioResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
