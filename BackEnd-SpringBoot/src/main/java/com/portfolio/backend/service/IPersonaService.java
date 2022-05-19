package com.portfolio.backend.service;

import com.portfolio.backend.models.Persona;
import java.util.List;

public interface IPersonaService {
    public void crearPersona(Persona persona);
    public void borrarPersona (Long id);
    public void modificarPersona(Persona persona);
    public Persona buscarPersona (Long id);
    public List<Persona> verPersonas();
}
