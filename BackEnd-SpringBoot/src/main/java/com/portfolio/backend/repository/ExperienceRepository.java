package com.portfolio.backend.repository;

import com.portfolio.backend.model.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository <Experience, Long> {
    public Optional<Experience> findByCompany (String company);
    public boolean existsByCompany(String company);
}
