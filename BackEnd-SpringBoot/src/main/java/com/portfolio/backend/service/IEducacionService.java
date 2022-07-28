package com.portfolio.backend.service;

import com.portfolio.backend.models.Educacion;
import java.util.List;

public interface IEducacionService {
    public Educacion guardarEducacion(Educacion educacion);
    public void borrarEducacion (Long id);
    public Educacion buscarEducacion (Long id);
    public List<Educacion> listarEducaciones();
}
