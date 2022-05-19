package com.portfolio.backend.controller;

import com.portfolio.backend.models.Proyecto;
import com.portfolio.backend.service.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proServ;
    
    @PostMapping("/new/proyecto")
    public void crearProyecto(@RequestBody Proyecto proyecto){
        proServ.crearProyecto(proyecto);
    }
    
    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proServ.borrarProyecto(id);
    }
    
    @PutMapping("/modificar/proyecto")
    public void modificarProyecto(@RequestBody Proyecto proyecto){
        proServ.modificarProyecto(proyecto);
    }
    
    @GetMapping("/buscar/proyecto/{id}")
    @ResponseBody
    public Proyecto buscarProyecto(@PathVariable Long id){
        return proServ.buscarProyecto(id);
    }
    
    @GetMapping("/ver/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos(){
        return proServ.verProyectos();
    }
}
