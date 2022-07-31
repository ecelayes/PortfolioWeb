package com.portfolio.backend.service;

import com.portfolio.backend.model.Project;
import com.portfolio.backend.repository.ProjectRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectService {
    
    @Autowired
    ProjectRepository projectRepository;
    
    public void save(Project project){
        projectRepository.save(project);
    }
    
    public void delete(Long id){
        projectRepository.deleteById(id);
    }
    
    public Optional<Project> getOne(Long id){
        return projectRepository.findById(id);
    }
    
    public Optional<Project> getByNameProject (String nameProject){
        return projectRepository.findByNameProject(nameProject);
    }
    
    public List<Project> list(){
        return projectRepository.findAll();
    }
    
    public boolean existById(Long id){
        return projectRepository.existsById(id);
    }
    
    public boolean existsByNameProject(String nameProject){
        return projectRepository.existsByNameProject(nameProject);         
    }
}
