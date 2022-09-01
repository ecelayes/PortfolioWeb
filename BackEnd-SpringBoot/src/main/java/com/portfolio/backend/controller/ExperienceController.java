package com.portfolio.backend.controller;

import com.portfolio.backend.dto.ExperienceDto;
import com.portfolio.backend.model.Experience;
import com.portfolio.backend.security.model.Message;
import com.portfolio.backend.service.ExperienceService;
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
@RequestMapping("/experience")
@CrossOrigin("http://localhost:4200/")
public class ExperienceController {
    
    @Autowired
    ExperienceService experienceService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Experience>> list(){
        List<Experience> list = experienceService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") Long id){
        if(!experienceService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!experienceService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        experienceService.delete(id);
        return new ResponseEntity(new Message("Experiencia laboral eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDto experienceDto) {
        if (StringUtils.isBlank(experienceDto.getCompany())) {
            return new ResponseEntity(new Message("La empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienceDto.getPosition())) {
            return new ResponseEntity(new Message("El cargo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienceService.existsByCompany(experienceDto.getCompany())) {
            return new ResponseEntity(new Message("La empresa ingresada ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = new Experience(experienceDto.getCompany(),
                                            experienceDto.getPosition(),
                                            experienceDto.getStartDate(),
                                            experienceDto.getEndDate(),
                                            experienceDto.getDescription(),
                                            experienceDto.getDirIcon());
        experienceService.save(experience);
        return new ResponseEntity(new Message("Nueva experiencia laboral agregada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienceDto experienceDto){
        if(!experienceService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getCompany()))
            return new ResponseEntity(new Message("La empresa es obligatoria"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getPosition()))
            return new ResponseEntity(new Message("El cargo es obligatorio"), HttpStatus.BAD_REQUEST);
        Experience experience = experienceService.getOne(id).get();
                        experience.setCompany(experienceDto.getCompany());
                        experience.setPosition(experienceDto.getPosition());
                        experience.setStartDate(experienceDto.getStartDate());
                        experience.setEndDate(experienceDto.getEndDate());
                        experience.setDescription(experienceDto.getDescription());
                        experience.setDirIcon(experienceDto.getDirIcon());
        experienceService.save(experience);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
