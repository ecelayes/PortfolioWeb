package com.portfolio.backend.service;

import com.portfolio.backend.models.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    public ProjectRepository proRepo;
    
    @Override
    public void createProject(Project project) {
        proRepo.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        return proRepo.findById(id).orElse(null);
    }

    @Override
    public List<Project> toListProjects() {
        return proRepo.findAll();
    }
    
}
