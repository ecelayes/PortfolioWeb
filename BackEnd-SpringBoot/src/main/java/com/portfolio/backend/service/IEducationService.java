package com.portfolio.backend.service;

import com.portfolio.backend.models.Education;
import java.util.List;

public interface IEducationService {
    public void createEducation(Education education);
    public void deleteEducation (Long id);
    public Education findEducation (Long id);
    public List<Education> toListEducations();
}
