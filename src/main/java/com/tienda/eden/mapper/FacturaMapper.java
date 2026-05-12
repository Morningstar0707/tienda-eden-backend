package com.tienda.eden.mapper;

import com.tienda.eden.dto.FacturaRequestDto;
import com.tienda.eden.dto.FacturaResponseDto;
import com.tienda.eden.entity.Factura;

public class FacturaMapper {

    private FacturaMapper() {
    }

    public static Factura toEntity(FacturaRequestDto dto) {
        Factura entity = new Factura();
        entity.setIdUsuario(dto.idUsuario());
        entity.setIdEstadoFactura(dto.idEstadoFactura());
        entity.setFechaFactura(dto.fechaFactura());
        entity.setNombreCliente(dto.nombreCliente());
        entity.setTelefonoCliente(dto.telefonoCliente());
        entity.setDireccionEnvio(dto.direccionEnvio());
        entity.setBarrioEnvio(dto.barrioEnvio());
        entity.setCiudadEnvio(dto.ciudadEnvio());
        entity.setDepartamentoEnvio(dto.departamentoEnvio());
        entity.setSubtotal(dto.subtotal());
        entity.setIva(dto.iva());
        entity.setNotasFactura(dto.notasFactura());
        return entity;
    }

    public static FacturaResponseDto toResponseDto(Factura entity) {
        return new FacturaResponseDto(
                entity.getIdFactura(),
                entity.getIdUsuario(),
                entity.getIdEstadoFactura(),
                entity.getFechaFactura(),
                entity.getNombreCliente(),
                entity.getTelefonoCliente(),
                entity.getDireccionEnvio(),
                entity.getBarrioEnvio(),
                entity.getCiudadEnvio(),
                entity.getDepartamentoEnvio(),
                entity.getSubtotal(),
                entity.getIva(),
                entity.getNotasFactura()
        );
    }

    public static void updateEntity(Factura entity, FacturaRequestDto dto) {
        entity.setIdUsuario(dto.idUsuario());
        entity.setIdEstadoFactura(dto.idEstadoFactura());
        entity.setFechaFactura(dto.fechaFactura());
        entity.setNombreCliente(dto.nombreCliente());
        entity.setTelefonoCliente(dto.telefonoCliente());
        entity.setDireccionEnvio(dto.direccionEnvio());
        entity.setBarrioEnvio(dto.barrioEnvio());
        entity.setCiudadEnvio(dto.ciudadEnvio());
        entity.setDepartamentoEnvio(dto.departamentoEnvio());
        entity.setSubtotal(dto.subtotal());
        entity.setIva(dto.iva());
        entity.setNotasFactura(dto.notasFactura());
    }
}
