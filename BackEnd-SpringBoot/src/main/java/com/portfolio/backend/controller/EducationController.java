package com.portfolio.backend.controller;

import com.portfolio.backend.dto.EducationDto;
import com.portfolio.backend.model.Education;
import com.portfolio.backend.security.model.Message;
import com.portfolio.backend.service.EducationService;
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
@RequestMapping("/education")
public class EducationController {
    
    @Autowired
    EducationService educationService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Education>> list(){
        List<Education> list = educationService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") Long id){
        if(!educationService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        Education education = educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!educationService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        educationService.delete(id);
        return new ResponseEntity(new Message("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDto educationDto) {
        if (StringUtils.isBlank(educationDto.getDegree())) {
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educationDto.getCareer())) {
            return new ResponseEntity(new Message("La carrera es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (educationService.existsByDegree(educationDto.getDegree())) {
            return new ResponseEntity(new Message("El titulo ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(educationDto.getInstitution(),
                                            educationDto.getDegree(), 
                                            educationDto.getCareer(), 
                                            educationDto.getStartDate(),
                                            educationDto.getEndDate(), 
                                            educationDto.getDirIcon());
        educationService.save(education);
        return new ResponseEntity(new Message("Nueva educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EducationDto educationDto){
        if(!educationService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getDegree()))
            return new ResponseEntity(new Message("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getCareer()))
            return new ResponseEntity(new Message("La carrera es obligatoria"), HttpStatus.BAD_REQUEST);
        Education education = educationService.getOne(id).get();
                        education.setInstitution(educationDto.getInstitution());
                        education.setDegree(educationDto.getDegree());
                        education.setCareer(educationDto.getCareer());
                        education.setStartDate(educationDto.getStartDate());
                        education.setEndDate(educationDto.getEndDate());
                        education.setDirIcon(educationDto.getDirIcon());
        educationService.save(education);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
