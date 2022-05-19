package com.portfolio.backend.service;

import com.portfolio.backend.models.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public void crearExperiencia(Experiencia experiencia) {
        expRepo.save(experiencia);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public void modificarExperiencia(Experiencia experiencia) {
        expRepo.save(experiencia);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public List<Experiencia> verExperiencias() {
        return expRepo.findAll();
    }
    
}
