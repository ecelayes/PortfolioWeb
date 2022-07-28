package com.portfolio.backend.service;

import com.portfolio.backend.models.Persona;
import java.util.List;

public interface IPersonaService {
    public Persona guardarPersona(Persona persona);
    public void borrarPersona (Long id);
    public Persona buscarPersona (Long id);
    public List<Persona> listarPersonas();
}
