package com.tienda.eden.controller;

import com.tienda.eden.dto.PagoFacturaRequestDto;
import com.tienda.eden.dto.PagoFacturaResponseDto;
import com.tienda.eden.service.PagoFacturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos-factura")
public class PagoFacturaController {

    private final PagoFacturaService service;

    public PagoFacturaController(PagoFacturaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PagoFacturaResponseDto crear(@Valid @RequestBody PagoFacturaRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<PagoFacturaResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PagoFacturaResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PagoFacturaResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody PagoFacturaRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
