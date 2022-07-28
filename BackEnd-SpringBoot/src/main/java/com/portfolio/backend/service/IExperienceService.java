package com.portfolio.backend.service;

import com.portfolio.backend.models.Experience;
import java.util.List;

public interface IExperienceService {
    public void createExperience(Experience experience);
    public void deleteExperience (Long id);
    public Experience findExperience (Long id);
    public List<Experience> toListExperiences();
}
