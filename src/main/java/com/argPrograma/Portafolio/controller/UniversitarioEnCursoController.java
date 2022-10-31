package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.UniversitarioEnCurso;
import com.argPrograma.Portafolio.services.UniversitarioEnCursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universitario-en-curso")
@CrossOrigin("https://portafolio-frontend-f5c86.web.app")
public class UniversitarioEnCursoController {
    private final UniversitarioEnCursoService universitarioEnCursoService;
    public UniversitarioEnCursoController(UniversitarioEnCursoService universitarioEnCursoService){
        this.universitarioEnCursoService=universitarioEnCursoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversitarioEnCurso> buscarPorId(@PathVariable("id") Long id) {
        UniversitarioEnCurso curso = universitarioEnCursoService.buscarPorId(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<UniversitarioEnCurso> listar() {
        return universitarioEnCursoService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<UniversitarioEnCurso> editar(@RequestBody UniversitarioEnCurso univ){
        UniversitarioEnCurso editado = universitarioEnCursoService.editar(univ);
        return new ResponseEntity<>(editado,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<UniversitarioEnCurso> agregar(@RequestBody UniversitarioEnCurso univ) {
        UniversitarioEnCurso editado = universitarioEnCursoService.editar(univ);
        return new ResponseEntity<>(editado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.universitarioEnCursoService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
