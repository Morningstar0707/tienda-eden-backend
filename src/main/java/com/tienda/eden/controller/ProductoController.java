package com.tienda.eden.controller;

import com.tienda.eden.dto.ProductoRequestDto;
import com.tienda.eden.dto.ProductoResponseDto;
import com.tienda.eden.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDto crear(@Valid @RequestBody ProductoRequestDto dto) {
        return service.crear(dto);
    }

    @GetMapping
    public List<ProductoResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ProductoResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProductoResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody ProductoRequestDto dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
