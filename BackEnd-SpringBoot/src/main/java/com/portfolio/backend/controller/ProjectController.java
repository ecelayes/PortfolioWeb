package com.portfolio.backend.controller;

import com.portfolio.backend.dto.ProjectDto;
import com.portfolio.backend.model.Project;
import com.portfolio.backend.security.model.Message;
import com.portfolio.backend.service.ProjectService;
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
@RequestMapping("/project")
@CrossOrigin("http://localhost:4200/")
public class ProjectController {
    
    @Autowired
    ProjectService projectService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Project>> list(){
        List<Project> list = projectService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") Long id){
        if(!projectService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        Project project = projectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!projectService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        projectService.delete(id);
        return new ResponseEntity(new Message("Projecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProjectDto projectDto) {
        if (StringUtils.isBlank(projectDto.getNameProject())) {
            return new ResponseEntity(new Message("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectDto.getStartDate())) {
            return new ResponseEntity(new Message("La fecha de inicio del proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (projectService.existsByNameProject(projectDto.getNameProject())) {
            return new ResponseEntity(new Message("El proyecto ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        Project project = new Project(projectDto.getNameProject(),
                                    projectDto.getDirImage(),
                                    projectDto.getStartDate(),
                                    projectDto.getEndDate(),
                                    projectDto.getDescription(),
                                    projectDto.getLink());
        projectService.save(project);
        return new ResponseEntity(new Message("Nuevo proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProjectDto projectDto){
        if(!projectService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getNameProject()))
            return new ResponseEntity(new Message("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getStartDate()))
            return new ResponseEntity(new Message("La fecha de inicio del proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        Project project = projectService.getOne(id).get();
                        project.setNameProject(projectDto.getNameProject());
                        project.setDirImage(projectDto.getDirImage());
                        project.setStartDate(projectDto.getStartDate());
                        project.setEndDate(projectDto.getEndDate());
                        project.setDescription(projectDto.getDescription());
                        project.setLink(projectDto.getLink());
        projectService.save(project);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
