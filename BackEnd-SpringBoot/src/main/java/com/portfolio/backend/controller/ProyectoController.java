package com.portfolio.backend.controller;

import com.portfolio.backend.models.Proyecto;
import com.portfolio.backend.service.IProyectoService;
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
@RequestMapping("/proyecto")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proServ;
    
    @PostMapping("/guardar")
    public Proyecto guardarProyecto(@RequestBody Proyecto proyecto){
        return proServ.guardarProyecto(proyecto);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarProyecto(@PathVariable("id") Long id){
        proServ.borrarProyecto(id);
    }
    
    @PutMapping("/modificar/{id}")
    public Proyecto modificarProyecto(@PathVariable("id") Long id, @RequestBody Proyecto proyecto){
        proyecto.setId(id);
        return proServ.guardarProyecto(proyecto);
    }
    
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Proyecto buscarProyecto(@PathVariable("id") Long id){
        return proServ.buscarProyecto(id);
    }
    
    @GetMapping("/listar")
    @ResponseBody
    public List<Proyecto> listarProyectos(){
        return proServ.listarProyectos();
    }
}
