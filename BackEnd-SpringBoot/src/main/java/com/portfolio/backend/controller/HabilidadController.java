package com.portfolio.backend.controller;

import com.portfolio.backend.models.Habilidad;
import com.portfolio.backend.service.IHabilidadService;
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
@RequestMapping("/habilidad")
public class HabilidadController {
    
    @Autowired
    private IHabilidadService expServ;
    
    @PostMapping("/guardar")
    public Habilidad guardarHabilidad(@RequestBody Habilidad habilidad){
        return expServ.guardarHabilidad(habilidad);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarHabilidad(@PathVariable("id") Long id){
        expServ.borrarHabilidad(id);
    }
    
    @PutMapping("/modificar/{id}")
    public Habilidad modificarHabilidad(@PathVariable("id") Long id, @RequestBody Habilidad habilidad){
        habilidad.setId(id);
        return expServ.guardarHabilidad(habilidad);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Habilidad buscarHabilidad(@PathVariable("id") Long id){
        return expServ.buscarHabilidad(id);
    }
    
    @GetMapping("/listar")
    @ResponseBody
    public List<Habilidad> listarHabilidades(){
        return expServ.listarHabilidades();
    }
}
