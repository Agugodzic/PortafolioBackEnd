package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.Experiencia;
import com.argPrograma.Portafolio.services.ExperienciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin("http://portafolio-frontend-f5c86.web.app")
public class ExperienciaController {
    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService){
        this.experienciaService=experienciaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> buscarPorId(@PathVariable("id") Long id) {
        Experiencia experiencia = experienciaService.buscarPorId(id);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Experiencia> listar() {
        return experienciaService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<Experiencia> editar(@RequestBody Experiencia experiencia){
        Experiencia editarExperiencia = experienciaService.editar(experiencia);
        return new ResponseEntity<>(editarExperiencia,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<Experiencia> agregar(@RequestBody Experiencia experiencia){
        Experiencia nuevaExperiencia = experienciaService.agregar(experiencia);
        return new ResponseEntity<>(nuevaExperiencia,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.experienciaService.eliminar(id);
        if(ok) {
            return "El elemento se elimino correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}

