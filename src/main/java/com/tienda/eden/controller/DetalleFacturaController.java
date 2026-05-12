package com.tienda.eden.controller;

import com.tienda.eden.dto.DetalleFacturaRequestDto;
import com.tienda.eden.dto.DetalleFacturaResponseDto;
import com.tienda.eden.service.DetalleFacturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-factura")
public class DetalleFacturaController {

    private final DetalleFacturaService service;

    public DetalleFacturaController(DetalleFacturaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleFacturaResponseDto crear(@Valid @RequestBody DetalleFacturaRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<DetalleFacturaResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DetalleFacturaResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public DetalleFacturaResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody DetalleFacturaRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
