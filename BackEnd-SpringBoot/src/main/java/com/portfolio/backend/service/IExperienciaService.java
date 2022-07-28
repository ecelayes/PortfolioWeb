package com.portfolio.backend.service;

import com.portfolio.backend.models.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public Experiencia guardarExperiencia(Experiencia experiencia);
    public void borrarExperiencia (Long id);
    public Experiencia buscarExperiencia (Long id);
    public List<Experiencia> listarExperiencias();
}
