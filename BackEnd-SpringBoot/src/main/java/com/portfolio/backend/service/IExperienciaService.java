package com.portfolio.backend.service;

import com.portfolio.backend.models.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public void crearExperiencia(Experiencia experiencia);
    public void borrarExperiencia (Long id);
    public void modificarExperiencia(Experiencia experiencia);
    public Experiencia buscarExperiencia (Long id);
    public List<Experiencia> verExperiencias();
}
