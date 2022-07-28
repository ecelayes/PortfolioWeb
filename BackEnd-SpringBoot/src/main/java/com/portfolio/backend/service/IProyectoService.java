package com.portfolio.backend.service;

import com.portfolio.backend.models.Proyecto;
import java.util.List;

public interface IProyectoService {
    public Proyecto guardarProyecto(Proyecto proyecto);
    public void borrarProyecto (Long id);
    public Proyecto buscarProyecto (Long id);
    public List<Proyecto> listarProyectos();
}
