package com.example.ventas.servicios;
import com.example.ventas.models.Persona;
import com.example.ventas.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Personas {
    private PersonaRepository personaRepository;

    public Personas(PersonaRepository persona) {
        this.personaRepository = persona;
    }

    public Persona guardarPersona(Persona persona) {
        if(persona.getNombre() == null || persona.getApellidoPaterno() == null || persona.getIdentificacion() == null) {
            throw new IllegalArgumentException("Campos obligatorios no presentes");
        }
        return personaRepository.save(persona);
    }

    public Optional<Persona> buscarPorIdentificacion(String identificacion) {
        return personaRepository.findByIdentificacion(identificacion);
    }

    public List<Persona> buscarTodas() {
        return personaRepository.findAll();
    }

    @Transactional
    public void deletePersonaByIdentifiacion(String identificacion) {
        Optional<Persona> persona = personaRepository.findByIdentificacion(identificacion);
        persona.ifPresent(personaRepository::delete);
    }

}