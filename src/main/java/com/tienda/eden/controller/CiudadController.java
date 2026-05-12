package com.tienda.eden.controller;

import com.tienda.eden.dto.CiudadRequestDto;
import com.tienda.eden.dto.CiudadResponseDto;
import com.tienda.eden.service.CiudadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    private final CiudadService service;

    public CiudadController(CiudadService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CiudadResponseDto crear(@Valid @RequestBody CiudadRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<CiudadResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CiudadResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CiudadResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody CiudadRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
