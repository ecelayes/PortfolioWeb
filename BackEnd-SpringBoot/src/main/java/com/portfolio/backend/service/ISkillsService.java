package com.portfolio.backend.service;

import com.portfolio.backend.models.Skills;
import java.util.List;

public interface ISkillsService {
    public void createSkills(Skills skills);
    public void deleteSkills (Long id);
    public Skills findSkills (Long id);
    public List<Skills> toListSkills();
}
