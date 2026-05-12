package com.tienda.eden.controller;

import com.tienda.eden.dto.MetodoPagoRequestDto;
import com.tienda.eden.dto.MetodoPagoResponseDto;
import com.tienda.eden.service.MetodoPagoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos-pago")
public class MetodoPagoController {

    private final MetodoPagoService service;

    public MetodoPagoController(MetodoPagoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MetodoPagoResponseDto crear(@Valid @RequestBody MetodoPagoRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<MetodoPagoResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public MetodoPagoResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public MetodoPagoResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody MetodoPagoRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
