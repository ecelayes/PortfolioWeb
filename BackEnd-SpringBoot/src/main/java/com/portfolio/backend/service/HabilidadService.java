package com.portfolio.backend.service;

import com.portfolio.backend.models.Habilidad;
import com.portfolio.backend.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService{

    @Autowired
    public HabilidadRepository habRepo;
    
    @Override
    public void crearHabilidad(Habilidad habilidad) {
        habRepo.save(habilidad);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habRepo.deleteById(id);
    }

    @Override
    public void modificarHabilidad(Habilidad habilidad) {
        habRepo.save(habilidad);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habRepo.findById(id).orElse(null);
    }

    @Override
    public List<Habilidad> verHabilidades() {
        return habRepo.findAll();
    }
    
}
