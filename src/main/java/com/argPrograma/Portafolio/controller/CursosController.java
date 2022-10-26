package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.Cursos;
import com.argPrograma.Portafolio.services.CursosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@CrossOrigin("https://portafolio-frontend-f5c86.web.app/")
public class CursosController {
    private final CursosService cursosService;
    public CursosController(CursosService cursosService){
        this.cursosService=cursosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cursos> buscarPorId(@PathVariable("id") Long id) {
        Cursos curso = cursosService.buscarPorId(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Cursos> listar() {
        return cursosService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<Cursos> editar(@RequestBody Cursos curso){
        Cursos editarCurso = cursosService.editar(curso);
        return new ResponseEntity<>(editarCurso,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<Cursos> agregar(@RequestBody Cursos curso){
        Cursos nuevoCurso = cursosService.agregar(curso);
        return new ResponseEntity<>(nuevoCurso,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.cursosService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
