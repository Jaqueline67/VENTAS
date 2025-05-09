package com.example.ventas.repositories;


import com.example.ventas.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonaRepository extends JpaRepository<Persona, Long>{
    Optional<Persona> findByIdentificacion(String identificacion);
    String deleteByIdentificacion(String identificacion);
}

