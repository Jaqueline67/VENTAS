package com.example.ventas.servicios;

import com.example.ventas.models.Factura;
import com.example.ventas.models.Persona;
import com.example.ventas.repositories.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facturas {
    private FacturaRepository facturaRepository;

    public Facturas(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> obtenerFacturasPorPersona(Long personaId) {
        return facturaRepository.findByPersonaId(personaId);
    }

    public Factura guardarFactura(Long personaId, Double monto) {
        if(monto == null) {
            throw new IllegalArgumentException("El monto es requerido");
        }
        Persona persona = new Persona();
        persona.setId(personaId);

        Factura factura = new Factura();
        factura.setPersona(persona);
        factura.setMonto(monto);

        return facturaRepository.save(factura);
    }
}

