package com.portfolio.backend.service;

import com.portfolio.backend.models.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.repository.PersonRepository;

@Service
public class PersonService implements IPersonService{
    
    @Autowired
    private PersonRepository personRepo;  

    @Override
    public void createPerson(Person person) {
       personRepo.save(person);
    }
    
    @Override
    public void deletePerson(Long id){
        personRepo.deleteById(id);
    }
    
    @Override
    public Person findPerson(Long id){
        return personRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Person> toListPersons() {
        return personRepo.findAll();
    }
    
}
