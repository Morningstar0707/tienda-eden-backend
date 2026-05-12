package com.tienda.eden.controller;

import com.tienda.eden.dto.FacturaRequestDto;
import com.tienda.eden.dto.FacturaResponseDto;
import com.tienda.eden.service.FacturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FacturaResponseDto crear(@Valid @RequestBody FacturaRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<FacturaResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public FacturaResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FacturaResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody FacturaRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
