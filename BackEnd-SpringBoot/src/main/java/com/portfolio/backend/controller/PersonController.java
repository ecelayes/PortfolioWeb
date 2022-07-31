package com.portfolio.backend.controller;

import com.portfolio.backend.dto.PersonDto;
import com.portfolio.backend.model.Person;
import com.portfolio.backend.security.model.Message;
import com.portfolio.backend.service.PersonService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    PersonService personService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Person>> list(){
        List<Person> list = personService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") Long id){
        if(!personService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        Person person = personService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!personService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        personService.delete(id);
        return new ResponseEntity(new Message("Persona eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonDto personDto) {
        if (StringUtils.isBlank(personDto.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personDto.getSurname())) {
            return new ResponseEntity(new Message("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (personService.existsByName(personDto.getName())) {
            return new ResponseEntity(new Message("El nombre ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        Person person = new Person(personDto.getName(),
                                    personDto.getSurname(), 
                                    personDto.getTitle(), 
                                    personDto.getLocation(),
                                    personDto.getDescription(), 
                                    personDto.getDirPhoto(),
                                    personDto.getDirBanner());
        personService.save(person);
        return new ResponseEntity(new Message("Nueva persona agregada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PersonDto personDto){
        if(!personService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personDto.getSurname()))
            return new ResponseEntity(new Message("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        Person person = personService.getOne(id).get();
                        person.setName(personDto.getName());
                        person.setSurname(personDto.getSurname());
                        person.setTitle(personDto.getTitle());
                        person.setLocation(personDto.getLocation());
                        person.setDescription(personDto.getDescription());
                        person.setDirPhoto(personDto.getDirPhoto());
                        person.setDirBanner(personDto.getDirBanner());
        personService.save(person);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
