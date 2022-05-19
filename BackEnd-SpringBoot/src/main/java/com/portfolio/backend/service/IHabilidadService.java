package com.portfolio.backend.service;

import com.portfolio.backend.models.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public void crearHabilidad(Habilidad habilidad);
    public void borrarHabilidad (Long id);
    public void modificarHabilidad(Habilidad habilidad);
    public Habilidad buscarHabilidad (Long id);
    public List<Habilidad> verHabilidades();
}
