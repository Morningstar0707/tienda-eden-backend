package com.tienda.eden.controller;

import com.tienda.eden.dto.CategoriaRequestDto;
import com.tienda.eden.dto.CategoriaResponseDto;
import com.tienda.eden.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponseDto crear(@Valid @RequestBody CategoriaRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<CategoriaResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
