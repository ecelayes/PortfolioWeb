package com.portfolio.backend.controller;

import com.portfolio.backend.models.Education;
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
import com.portfolio.backend.service.IEducationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/education")
public class EducationController {
    
    @Autowired
    private IEducationService eduServ;
    
    @PostMapping("/create")
    public void createEducation(@RequestBody Education education){
        eduServ.createEducation(education);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteEduation(@PathVariable("id") Long id){
        eduServ.deleteEducation(id);
    }
    
    @PutMapping("/update/{id}")
    public void modificarEduation(@PathVariable("id") Long id, @RequestBody Education education){
        education.setId(id);
        eduServ.createEducation(education);
    }
    
    @GetMapping("/find/{id}")
    @ResponseBody
    public Education buscarEducation(@PathVariable("id") Long id){
        return eduServ.findEducation(id);
    }
    
    @GetMapping("/tolist")
    @ResponseBody
    public List<Education> toListEducations(){
        return eduServ.toListEducations();
    }
}
