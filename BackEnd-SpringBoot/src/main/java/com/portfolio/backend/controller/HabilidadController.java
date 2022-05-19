package com.portfolio.backend.controller;

import com.portfolio.backend.models.Habilidad;
import com.portfolio.backend.service.IHabilidadService;
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
public class HabilidadController {
    
    @Autowired
    private IHabilidadService expServ;
    
    @PostMapping("/new/habilidad")
    public void crearHabilidad(@RequestBody Habilidad habilidad){
        expServ.crearHabilidad(habilidad);
    }
    
    @DeleteMapping("/delete/habilidad/{id}")
    public void borrarHabilidad(@PathVariable Long id){
        expServ.borrarHabilidad(id);
    }
    
    @PutMapping("/modificar/habilidad")
    public void modificarHabilidad(@RequestBody Habilidad habilidad){
        expServ.modificarHabilidad(habilidad);
    }
    
    @GetMapping("/buscar/habilidad/{id}")
    @ResponseBody
    public Habilidad buscarHabilidad(@PathVariable Long id){
        return expServ.buscarHabilidad(id);
    }
    
    @GetMapping("/ver/habilidad")
    @ResponseBody
    public List<Habilidad> verHabilidades(){
        return expServ.verHabilidades();
    }
}
