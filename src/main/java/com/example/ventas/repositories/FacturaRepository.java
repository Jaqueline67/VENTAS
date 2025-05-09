package com.example.ventas.repositories;

import com.example.ventas.models.Factura;
import com.example.ventas.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByPersonaId(Long personaId);
}