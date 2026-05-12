package com.tienda.eden.controller;

import com.tienda.eden.dto.DireccionRequestDto;
import com.tienda.eden.dto.DireccionResponseDto;
import com.tienda.eden.service.DireccionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DireccionResponseDto crear(@Valid @RequestBody DireccionRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<DireccionResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DireccionResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DireccionResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody DireccionRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
