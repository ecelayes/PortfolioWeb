package com.portfolio.backend.service;

import com.portfolio.backend.models.Educacion;
import com.portfolio.backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public void crearEducacion(Educacion educacion) {
        eduRepo.save(educacion);
    }

    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public void modificarEducacion(Educacion educacion) {
        eduRepo.save(educacion);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

    @Override
    public List<Educacion> verEducaciones() {
       return eduRepo.findAll();
    }
    
}
