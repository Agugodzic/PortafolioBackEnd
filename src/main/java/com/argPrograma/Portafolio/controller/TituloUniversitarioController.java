package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.TituloUniversitario;
import com.argPrograma.Portafolio.services.TituloUniversitarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/titulo-universitario")
public class TituloUniversitarioController {
    private final TituloUniversitarioService tituloUniversitarioService;
    public TituloUniversitarioController(TituloUniversitarioService tituloUniversitarioService){
        this.tituloUniversitarioService = tituloUniversitarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TituloUniversitario> buscarPorId(@PathVariable("id") Long id) {
        TituloUniversitario titulo = tituloUniversitarioService.buscarPorId(id);
        return new ResponseEntity<>(titulo, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<TituloUniversitario> listar() {
        return tituloUniversitarioService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<TituloUniversitario> editar(@RequestBody TituloUniversitario univ){
        TituloUniversitario editado = tituloUniversitarioService.editar(univ);
        return new ResponseEntity<>(editado,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<TituloUniversitario> agregar(@RequestBody TituloUniversitario univ) {
        TituloUniversitario editado = tituloUniversitarioService.editar(univ);
        return new ResponseEntity<>(editado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.tituloUniversitarioService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
