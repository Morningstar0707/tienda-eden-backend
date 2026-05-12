package com.tienda.eden.mapper;

import com.tienda.eden.dto.ProductoRequestDto;
import com.tienda.eden.dto.ProductoResponseDto;
import com.tienda.eden.entity.Producto;

public class ProductoMapper {

    private ProductoMapper() {
    }

    public static Producto toEntity(ProductoRequestDto dto) {
        Producto entity = new Producto();
        entity.setNombre(dto.nombre());
        entity.setDescripcion(dto.descripcion());
        entity.setPrecio(dto.precio());
        entity.setStock(dto.stock());
        entity.setImagenUrl(dto.imagenUrl());
        entity.setActivo(dto.activo());
        entity.setIdCategoria(dto.idCategoria());
        return entity;
    }

    public static ProductoResponseDto toResponseDto(Producto entity) {
        return new ProductoResponseDto(
                entity.getIdProducto(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getPrecio(),
                entity.getStock(),
                entity.getImagenUrl(),
                entity.getActivo(),
                entity.getIdCategoria()
        );
    }

    public static void updateEntity(Producto entity, ProductoRequestDto dto) {
        entity.setNombre(dto.nombre());
        entity.setDescripcion(dto.descripcion());
        entity.setPrecio(dto.precio());
        entity.setStock(dto.stock());
        entity.setImagenUrl(dto.imagenUrl());
        entity.setActivo(dto.activo());
        entity.setIdCategoria(dto.idCategoria());
    }
}
