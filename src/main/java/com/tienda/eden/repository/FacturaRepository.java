package com.tienda.eden.repository;

import com.tienda.eden.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
