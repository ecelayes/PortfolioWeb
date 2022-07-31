package com.portfolio.backend.service;

import com.portfolio.backend.model.Experience;
import com.portfolio.backend.repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {
    
    @Autowired
    ExperienceRepository experienceRepository;
    
    public void save(Experience experience){
        experienceRepository.save(experience);
    }
    
    public void delete(Long id){
        experienceRepository.deleteById(id);
    }
    
    public Optional<Experience> getOne(Long id){
        return experienceRepository.findById(id);
    }
    
    public Optional<Experience> getByCompany (String company){
        return experienceRepository.findByCompany(company);
    }
    
    public List<Experience> list(){
        return experienceRepository.findAll();
    }
    
    public boolean existById(Long id){
        return experienceRepository.existsById(id);
    }
    
    public boolean existsByCompany(String company){
        return experienceRepository.existsByCompany(company);         
    }
}
