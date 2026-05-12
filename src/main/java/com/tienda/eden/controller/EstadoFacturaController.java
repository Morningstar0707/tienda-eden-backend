package com.tienda.eden.controller;

import com.tienda.eden.dto.EstadoFacturaRequestDto;
import com.tienda.eden.dto.EstadoFacturaResponseDto;
import com.tienda.eden.service.EstadoFacturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados-factura")
public class EstadoFacturaController {

    private final EstadoFacturaService service;

    public EstadoFacturaController(EstadoFacturaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoFacturaResponseDto crear(@Valid @RequestBody EstadoFacturaRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<EstadoFacturaResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public EstadoFacturaResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public EstadoFacturaResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody EstadoFacturaRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
