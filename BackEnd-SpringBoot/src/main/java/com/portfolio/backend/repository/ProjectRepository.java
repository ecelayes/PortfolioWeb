package com.portfolio.backend.repository;

import com.portfolio.backend.model.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Long>{
    public Optional<Project> findByNameProject (String nameProject);
    public boolean existsByNameProject(String nameProject);
}
