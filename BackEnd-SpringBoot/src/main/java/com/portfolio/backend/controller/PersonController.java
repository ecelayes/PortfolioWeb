package com.portfolio.backend.controller;

import com.portfolio.backend.models.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.backend.service.IPersonService;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private IPersonService personServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public void createPerson(@RequestBody Person person){
        personServ.createPerson(person);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deletePersona(@PathVariable("id") Long id){
        personServ.deletePerson(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person){
        person.setId(id);
        personServ.createPerson(person);
    }
    
    @GetMapping("/find/{id}")
    @ResponseBody
    public Person findPersona(@PathVariable("id") Long id){
        return personServ.findPerson(id);
    }
    
    @GetMapping("/tolist")
    @ResponseBody
    public List<Person> toListPersons(){
        return personServ.toListPersons();
    }
}
