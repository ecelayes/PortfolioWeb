package com.portfolio.backend.controller;

import com.portfolio.backend.models.Project;
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
import com.portfolio.backend.service.IProjectService;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private IProjectService proServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public void createProject(@RequestBody Project project){
        proServ.createProject(project);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable("id") Long id){
        proServ.deleteProject(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public void updateProject(@PathVariable("id") Long id, @RequestBody Project project){
        project.setId(id);
        proServ.createProject(project);
    }
    
    @GetMapping("/find/{id}")
    @ResponseBody
    public Project findProject(@PathVariable("id") Long id){
        return proServ.findProject(id);
    }
    
    @GetMapping("/tolist")
    @ResponseBody
    public List<Project> toListProjects(){
        return proServ.toListProjects();
    }
}
