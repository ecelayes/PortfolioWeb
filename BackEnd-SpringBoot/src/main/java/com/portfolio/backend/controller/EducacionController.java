package com.portfolio.backend.controller;

import com.portfolio.backend.models.Educacion;
import com.portfolio.backend.service.IEducacionService;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/educacion")
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @PostMapping("/guardar")
    public void guardarEducacion(@RequestBody Educacion educacion){
        eduServ.guardarEducacion(educacion);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarEduacion(@PathVariable("id") Long id){
        eduServ.borrarEducacion(id);
    }
    
    @PutMapping("/modificar/{id}")
    public void modificarEduacion(@PathVariable("id") Long id, @RequestBody Educacion educacion){
        educacion.setId(id);
        eduServ.guardarEducacion(educacion);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable("id") Long id){
        return eduServ.buscarEducacion(id);
    }
    
    @GetMapping("/listar")
    @ResponseBody
    public List<Educacion> listarEducaciones(){
        return eduServ.listarEducaciones();
    }
}
