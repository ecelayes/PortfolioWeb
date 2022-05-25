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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaServ;
    
    @PostMapping("/new")
    public void crearPersona(@RequestBody Persona persona){
        personaServ.crearPersona(persona);
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaServ.borrarPersona(id);
    }
    
    @PutMapping("/modificar")
    public void modificarPersona(@RequestBody Persona persona){
        personaServ.modificarPersona(persona);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return personaServ.buscarPersona(id);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verPersonas(){
        return personaServ.verPersonas();
    }
}
