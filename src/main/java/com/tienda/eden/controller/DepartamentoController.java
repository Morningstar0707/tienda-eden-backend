package com.tienda.eden.controller;

import com.tienda.eden.dto.DepartamentoRequestDto;
import com.tienda.eden.dto.DepartamentoResponseDto;
import com.tienda.eden.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoResponseDto crear(@Valid @RequestBody DepartamentoRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<DepartamentoResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DepartamentoResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody DepartamentoRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
