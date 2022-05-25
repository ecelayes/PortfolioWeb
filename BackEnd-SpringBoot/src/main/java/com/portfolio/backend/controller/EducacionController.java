package com.portfolio.backend.controller;

import com.portfolio.backend.models.Educacion;
import com.portfolio.backend.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @PostMapping("/new")
    public void crearEducacion(@RequestBody Educacion educacion){
        eduServ.crearEducacion(educacion);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarEduacion(@PathVariable Long id){
        eduServ.borrarEducacion(id);
    }
    
    @PutMapping("/modificar")
    public void modificarEduacion(@RequestBody Educacion educacion){
        eduServ.modificarEducacion(educacion);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id){
        return eduServ.buscarEducacion(id);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Educacion> verEducaciones(){
        return eduServ.verEducaciones();
    }
}
