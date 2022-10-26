package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.Cursos;
import com.argPrograma.Portafolio.model.Proyectos;
import com.argPrograma.Portafolio.services.ProyectosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyectos")
@CrossOrigin("https://portafolio-frontend-f5c86.web.app/")
public class ProyectosController {
    private final ProyectosService proyectosService;

    public ProyectosController(ProyectosService proyectosService){
        this.proyectosService=proyectosService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Proyectos> buscarPorId(@PathVariable("id") Long id) {
        Proyectos proyecto = proyectosService.buscarPorId(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Proyectos> listar() {
        return proyectosService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<Proyectos> editar(@RequestBody Proyectos proyecto){
        Proyectos editarProyecto = proyectosService.editar(proyecto);
        return new ResponseEntity<>(editarProyecto, HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<Proyectos> agregar(@RequestBody Proyectos proyecto){
        Proyectos nuevoProyecto = proyectosService.agregar(proyecto);
        return new ResponseEntity<>(nuevoProyecto,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.proyectosService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }

}
