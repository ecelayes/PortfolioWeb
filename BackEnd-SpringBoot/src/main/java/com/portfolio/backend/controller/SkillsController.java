package com.portfolio.backend.controller;

import com.portfolio.backend.models.Skills;
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
import com.portfolio.backend.service.ISkillsService;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skills")
public class SkillsController {
    
    @Autowired
    private ISkillsService expServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public void createSkills(@RequestBody Skills skills){
        expServ.createSkills(skills);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteSkills(@PathVariable("id") Long id){
        expServ.deleteSkills(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public void updateSkills(@PathVariable("id") Long id, @RequestBody Skills skills){
        skills.setId(id);
        expServ.createSkills(skills);
    }
    
    @GetMapping("/find/{id}")
    @ResponseBody
    public Skills findSkills(@PathVariable("id") Long id){
        return expServ.findSkills(id);
    }
    
    @GetMapping("/tolist")
    @ResponseBody
    public List<Skills> toListSkills(){
        return expServ.toListSkills();
    }
}
