package com.portfolio.backend.service;

import com.portfolio.backend.models.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public Habilidad guardarHabilidad(Habilidad habilidad);
    public void borrarHabilidad (Long id);
    public Habilidad buscarHabilidad (Long id);
    public List<Habilidad> listarHabilidades();
}
