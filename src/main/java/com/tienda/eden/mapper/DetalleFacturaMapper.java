package com.tienda.eden.mapper;

import com.tienda.eden.dto.DetalleFacturaRequestDto;
import com.tienda.eden.dto.DetalleFacturaResponseDto;
import com.tienda.eden.entity.DetalleFactura;

public class DetalleFacturaMapper {

    private DetalleFacturaMapper() {
    }

    public static DetalleFactura toEntity(DetalleFacturaRequestDto dto) {
        DetalleFactura entity = new DetalleFactura();
        entity.setIdFactura(dto.idFactura());
        entity.setIdProducto(dto.idProducto());
        entity.setNombreProducto(dto.nombreProducto());
        entity.setCantidad(dto.cantidad());
        entity.setPrecioUnitario(dto.precioUnitario());
        entity.setSubtotal(dto.subtotal());
        return entity;
    }

    public static DetalleFacturaResponseDto toResponseDto(DetalleFactura entity) {
        return new DetalleFacturaResponseDto(
                entity.getIdDetalle(),
                entity.getIdFactura(),
                entity.getIdProducto(),
                entity.getNombreProducto(),
                entity.getCantidad(),
                entity.getPrecioUnitario(),
                entity.getSubtotal()
        );
    }

    public static void updateEntity(DetalleFactura entity, DetalleFacturaRequestDto dto) {
        entity.setIdFactura(dto.idFactura());
        entity.setIdProducto(dto.idProducto());
        entity.setNombreProducto(dto.nombreProducto());
        entity.setCantidad(dto.cantidad());
        entity.setPrecioUnitario(dto.precioUnitario());
        entity.setSubtotal(dto.subtotal());
    }
}
