package com.portfolio.backend.service;

import com.portfolio.backend.models.Proyecto;
import com.portfolio.backend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proRepo;
    
    @Override
    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proRepo.save(proyecto);
    }

    @Override
    public void borrarProyecto(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proRepo.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> listarProyectos() {
        return proRepo.findAll();
    }
    
}
