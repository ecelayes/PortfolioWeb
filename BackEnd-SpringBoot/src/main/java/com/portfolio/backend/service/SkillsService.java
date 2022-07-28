package com.portfolio.backend.service;

import com.portfolio.backend.models.Skills;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.repository.SkillsRepository;

@Service
public class SkillsService implements ISkillsService{

    @Autowired
    public SkillsRepository habRepo;
    
    @Override
    public void createSkills(Skills skills) {
        habRepo.save(skills);
    }

    @Override
    public void deleteSkills(Long id) {
        habRepo.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
        return habRepo.findById(id).orElse(null);
    }

    @Override
    public List<Skills> toListSkills() {
        return habRepo.findAll();
    }
    
}
