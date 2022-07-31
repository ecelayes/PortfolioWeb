package com.portfolio.backend.controller;

import com.portfolio.backend.dto.SkillDto;
import com.portfolio.backend.model.Skill;
import com.portfolio.backend.security.model.Message;
import com.portfolio.backend.service.SkillService;
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
@RequestMapping("/skill")
public class SkillController {
    
    @Autowired
    SkillService skillService;
    
    @GetMapping ("/list")
    public ResponseEntity <List<Skill>> list(){
        List<Skill> list = skillService.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") Long id){
        if(!skillService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!skillService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        skillService.delete(id);
        return new ResponseEntity(new Message("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getNameSkill())) {
            return new ResponseEntity(new Message("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillService.existsByNameSkill(skillDto.getNameSkill())) {
            return new ResponseEntity(new Message("La habilidad ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(skillDto.getNameSkill(),
                                skillDto.getDirIcon(),
                                skillDto.getPercentage());
        skillService.save(skill);
        return new ResponseEntity(new Message("Nueva habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SkillDto skillDto){
        if(!skillService.existById(id))
            return new ResponseEntity(new Message("El ID no existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getNameSkill()))
            return new ResponseEntity(new Message("El nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        Skill skill = skillService.getOne(id).get();
                        skill.setNameSkill(skillDto.getNameSkill());
                        skill.setDirIcon(skillDto.getDirIcon());
                        skill.setPercentage(skillDto.getPercentage());
        skillService.save(skill);
        return new ResponseEntity(new Message("Datos actualizados"), HttpStatus.OK);
    }
}
