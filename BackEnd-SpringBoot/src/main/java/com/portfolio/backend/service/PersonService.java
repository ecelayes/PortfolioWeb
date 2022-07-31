package com.portfolio.backend.service;

import com.portfolio.backend.model.Person;
import com.portfolio.backend.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {
    
    @Autowired
    PersonRepository personRepository;
    
    public void save(Person person){
        personRepository.save(person);
    }
    
    public void delete(Long id){
        personRepository.deleteById(id);
    }
    
    public Optional<Person> getOne(Long id){
        return personRepository.findById(id);
    }
    
    public Optional<Person> getByName (String name){
        return personRepository.findByName(name);
    }
    
    public List<Person> list(){
        return personRepository.findAll();
    }
    
    public boolean existById(Long id){
        return personRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return personRepository.existsByName(name);         
    }
}
