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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @PostMapping("/new/educacion")
    public void crearEducacion(@RequestBody Educacion educacion){
        eduServ.crearEducacion(educacion);
    }
    
    @DeleteMapping("/delete/educacion/{id}")
    public void borrarEduacion(@PathVariable Long id){
        eduServ.borrarEducacion(id);
    }
    
    @PutMapping("/modificar/educaion")
    public void modificarEduacion(@RequestBody Educacion educacion){
        eduServ.modificarEducacion(educacion);
    }
    
    @GetMapping("/buscar/educacion/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id){
        return eduServ.buscarEducacion(id);
    }
    
    @GetMapping("/ver/educaciones")
    @ResponseBody
    public List<Educacion> verEducaciones(){
        return eduServ.verEducaciones();
    }
}
