package com.portfolio.backend.repository;

import com.portfolio.backend.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository <Skill, Long>{
    public Optional<Skill> findByNameSkill (String nameSkill);
    public boolean existsByNameSkill(String nameSkill);
}
