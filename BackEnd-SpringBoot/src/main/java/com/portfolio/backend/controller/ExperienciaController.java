package com.portfolio.backend.controller;

import com.portfolio.backend.models.Experiencia;
import com.portfolio.backend.service.IExperienciaService;
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
@RequestMapping("/experiencia")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @PostMapping("/new")
    public void crearExperiencia(@RequestBody Experiencia experiencia){
        expServ.crearExperiencia(experiencia);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperiencia(id);
    }
    
    @PutMapping("/modificar")
    public void modificarExperiencia(@RequestBody Experiencia experiencia){
        expServ.modificarExperiencia(experiencia);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia(@PathVariable Long id){
        return expServ.buscarExperiencia(id);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Experiencia> verExperiencias(){
        return expServ.verExperiencias();
    }
}
