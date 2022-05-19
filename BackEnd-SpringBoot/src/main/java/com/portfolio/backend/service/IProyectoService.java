package com.portfolio.backend.service;

import com.portfolio.backend.models.Proyecto;
import java.util.List;

public interface IProyectoService {
    public void crearProyecto(Proyecto proyecto);
    public void borrarProyecto (Long id);
    public void modificarProyecto(Proyecto proyecto);
    public Proyecto buscarProyecto (Long id);
    public List<Proyecto> verProyectos();
}
