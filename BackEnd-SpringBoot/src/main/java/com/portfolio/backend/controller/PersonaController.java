package com.portfolio.backend.controller;

import com.portfolio.backend.models.Persona;
import com.portfolio.backend.service.IPersonaService;
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
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaServ;
    
    @PostMapping("/guardar")
    public Persona guardarPersona(@RequestBody Persona persona){
        return personaServ.guardarPersona(persona);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable("id") Long id){
        personaServ.borrarPersona(id);
    }
    
    @PutMapping("/editar/{id}")
    public Persona editarPersona(@PathVariable("id") Long id, @RequestBody Persona persona){
        persona.setId(id);
        return personaServ.guardarPersona(persona);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable("id") Long id){
        return personaServ.buscarPersona(id);
    }
    
    @GetMapping("/listar")
    @ResponseBody
    public List<Persona> listarPersonas(){
        return personaServ.listarPersonas();
    }
}
