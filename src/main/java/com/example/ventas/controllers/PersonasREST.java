package com.example.ventas.controllers;

import com.example.ventas.models.Persona;
import com.example.ventas.servicios.Personas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonasREST {
    private final Personas personas;

    public PersonasREST(Personas personas) {
        this.personas = personas;
    }

    @PostMapping
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(personas.guardarPersona(persona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable String id) {
        return personas.buscarPorIdentificacion(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public Object[] getPersonaAll() {
        return personas.buscarTodas().toArray();
    }

    @DeleteMapping("/{identificacion}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable String identificacion) {
        personas.deletePersonaByIdentifiacion(identificacion);
        return ResponseEntity.noContent().build();
    }


}

