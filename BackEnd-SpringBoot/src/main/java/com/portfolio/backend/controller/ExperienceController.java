package com.portfolio.backend.controller;

import com.portfolio.backend.models.Experience;
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
import com.portfolio.backend.service.IExperienceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experience")
public class ExperienceController {
    
    @Autowired
    private IExperienceService expServ;
    
    @PostMapping("/create")
    public void createExperience(@RequestBody Experience experience){
        expServ.createExperience(experience);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteExperience(@PathVariable("id") Long id){
        expServ.deleteExperience(id);
    }
    
    @PutMapping("/update/{id}")
    public void updateExperience(@PathVariable("id") Long id, @RequestBody Experience experience){
        experience.setId(id);
        expServ.createExperience(experience);
    }
    
    @GetMapping("/find/{id}")
    @ResponseBody
    public Experience findExperience(@PathVariable("id") Long id){
        return expServ.findExperience(id);
    }
    
    @GetMapping("/tolist")
    @ResponseBody
    public List<Experience> toListExperiences(){
        return expServ.toListExperiences();
    }
}
