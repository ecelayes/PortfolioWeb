package com.portfolio.backend.service;

import com.portfolio.backend.models.Person;
import java.util.List;

public interface IPersonService {
    public void createPerson(Person person);
    public void deletePerson (Long id);
    public Person findPerson (Long id);
    public List<Person> toListPersons();
}
