package com.portfolio.backend.service;

import com.portfolio.backend.models.Experience;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.repository.ExperienceRepository;

@Service
public class ExperienceService implements IExperienceService{

    @Autowired
    public ExperienceRepository expRepo;
    
    @Override
    public void createExperience(Experience experience) {
        expRepo.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public List<Experience> toListExperiences() {
        return expRepo.findAll();
    }
    
}
