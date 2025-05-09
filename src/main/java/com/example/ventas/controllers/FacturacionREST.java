package com.example.ventas.controllers;


import com.example.ventas.models.Factura;
import com.example.ventas.servicios.Facturas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturacionREST {

    private final Facturas facturas;

    public FacturacionREST(Facturas facturas) {
        this.facturas = facturas;
    }

    @GetMapping("/{personaId}")
    public ResponseEntity<List<Factura>> obtenerFacturas(@PathVariable Long personaId) {
        List<Factura> lista = facturas.obtenerFacturasPorPersona(personaId);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/{personaId}")
    public ResponseEntity<Factura> crearFactura(
            @PathVariable Long personaId,
            @RequestBody Factura factura_data
    ) {
        Factura factura = facturas.guardarFactura(personaId, factura_data.getMonto());
        return ResponseEntity.ok(factura);
    }
}
