package com.portfolio.backend.controller;

import com.portfolio.backend.models.Experiencia;
import com.portfolio.backend.service.IExperienciaService;
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
@RequestMapping("/experiencia")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @PostMapping("/guardar")
    public Experiencia guardarExperiencia(@RequestBody Experiencia experiencia){
        return expServ.guardarExperiencia(experiencia);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarExperiencia(@PathVariable("id") Long id){
        expServ.borrarExperiencia(id);
    }
    
    @PutMapping("/modificar/{id}")
    public Experiencia modificarExperiencia(@PathVariable("id") Long id, @RequestBody Experiencia experiencia){
        experiencia.setId(id);
        return expServ.guardarExperiencia(experiencia);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia(@PathVariable("id") Long id){
        return expServ.buscarExperiencia(id);
    }
    
    @GetMapping("/listar")
    @ResponseBody
    public List<Experiencia> listarExperiencias(){
        return expServ.listarExperiencias();
    }
}
