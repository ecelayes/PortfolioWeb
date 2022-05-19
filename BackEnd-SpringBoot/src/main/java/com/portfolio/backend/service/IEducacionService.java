package com.portfolio.backend.service;

import com.portfolio.backend.models.Educacion;
import java.util.List;

public interface IEducacionService {
    public void crearEducacion(Educacion educacion);
    public void borrarEducacion (Long id);
    public void modificarEducacion(Educacion educacion);
    public Educacion buscarEducacion (Long id);
    public List<Educacion> verEducaciones();
}
