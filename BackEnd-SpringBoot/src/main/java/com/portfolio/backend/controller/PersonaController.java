package com.portfolio.backend.controller;

import com.portfolio.backend.models.Persona;
import com.portfolio.backend.service.IPersonaService;
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
public class PersonaController {
    
    @Autowired
    private IPersonaService userServ;
    
    @PostMapping("/new/persona")
    public void crearPersona(@RequestBody Persona persona){
        userServ.crearPersona(persona);
    }
    
    @DeleteMapping("/delete/persona/{id}")
    public void borrarPersona(@PathVariable Long id){
        userServ.borrarPersona(id);
    }
    
    @PutMapping("/modificar/persona")
    public void modificarPersona(@RequestBody Persona persona){
        userServ.modificarPersona(persona);
    }
    
    @GetMapping("/buscar/persona/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return userServ.buscarPersona(id);
    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return userServ.verPersonas();
    }
}
