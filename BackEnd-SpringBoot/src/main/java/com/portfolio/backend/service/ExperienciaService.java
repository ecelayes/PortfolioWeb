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
    public Experiencia guardarExperiencia(Experiencia experiencia) {
        return expRepo.save(experiencia);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public List<Experiencia> listarExperiencias() {
        return expRepo.findAll();
    }
    
}
