package com.portfolio.backend.repository;

import com.portfolio.backend.model.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long>{
    public Optional<Person> findByName (String name);
    public boolean existsByName(String name);
}
