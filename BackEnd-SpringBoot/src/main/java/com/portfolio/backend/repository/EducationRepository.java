
package com.portfolio.backend.repository;

import com.portfolio.backend.model.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository <Education, Long> {
    public Optional<Education> findByDegree (String degree);
    public boolean existsByDegree(String degree);
}
