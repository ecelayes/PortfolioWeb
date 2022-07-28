package com.portfolio.backend.service;

import com.portfolio.backend.models.Education;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.repository.EducationRepository;

@Service
public class EducationService implements IEducationService{

    @Autowired
    public EducationRepository eduRepo;
    
    @Override
    public void createEducation(Education education) {
        eduRepo.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

    @Override
    public List<Education> toListEducations() {
       return eduRepo.findAll();
    }
    
}
