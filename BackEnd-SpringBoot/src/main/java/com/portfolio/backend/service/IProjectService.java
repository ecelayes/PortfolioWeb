package com.portfolio.backend.service;

import com.portfolio.backend.models.Project;
import java.util.List;

public interface IProjectService {
    public void createProject(Project project);
    public void deleteProject (Long id);
    public Project findProject (Long id);
    public List<Project> toListProjects();
}
