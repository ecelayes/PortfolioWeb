package com.portfolio.backend.service;

import com.portfolio.backend.model.Education;
import com.portfolio.backend.repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService {
    
    @Autowired
    EducationRepository educationRepository;
    
    public void save(Education education){
        educationRepository.save(education);
    }
    
    public void delete(Long id){
        educationRepository.deleteById(id);
    }
    
    public Optional<Education> getOne(Long id){
        return educationRepository.findById(id);
    }
    
    public Optional<Education> getByDegree (String degree){
        return educationRepository.findByDegree(degree);
    }
    
    public List<Education> list(){
        return educationRepository.findAll();
    }
    
    public boolean existById(Long id){
        return educationRepository.existsById(id);
    }
    
    public boolean existsByDegree(String degree){
        return educationRepository.existsByDegree(degree);         
    }
}
