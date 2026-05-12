package com.tienda.eden.mapper;

import com.tienda.eden.dto.PagoFacturaRequestDto;
import com.tienda.eden.dto.PagoFacturaResponseDto;
import com.tienda.eden.entity.PagoFactura;

public class PagoFacturaMapper {

    private PagoFacturaMapper() {
    }

    public static PagoFactura toEntity(PagoFacturaRequestDto dto) {
        PagoFactura entity = new PagoFactura();
        entity.setIdFactura(dto.idFactura());
        entity.setIdMetodoPago(dto.idMetodoPago());
        entity.setMonto(dto.monto());
        entity.setReferenciaPago(dto.referenciaPago());
        entity.setEstadoPago(dto.estadoPago());
        entity.setFechaPago(dto.fechaPago());
        return entity;
    }

    public static PagoFacturaResponseDto toResponseDto(PagoFactura entity) {
        return new PagoFacturaResponseDto(
                entity.getIdPago(),
                entity.getIdFactura(),
                entity.getIdMetodoPago(),
                entity.getMonto(),
                entity.getReferenciaPago(),
                entity.getEstadoPago(),
                entity.getFechaPago()
        );
    }

    public static void updateEntity(PagoFactura entity, PagoFacturaRequestDto dto) {
        entity.setIdFactura(dto.idFactura());
        entity.setIdMetodoPago(dto.idMetodoPago());
        entity.setMonto(dto.monto());
        entity.setReferenciaPago(dto.referenciaPago());
        entity.setEstadoPago(dto.estadoPago());
        entity.setFechaPago(dto.fechaPago());
    }
}
