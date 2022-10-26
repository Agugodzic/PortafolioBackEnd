package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.Portada;
import com.argPrograma.Portafolio.services.PortadaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portada")
@CrossOrigin("https://portafolio-frontend-f5c86.web.app/")
public class PortadaController {
    private final PortadaService portadaService;
    public PortadaController(PortadaService portadaService){
        this.portadaService=portadaService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Portada> buscarPorId(@PathVariable("id") Long id) {
        Portada portada = portadaService.buscarPorId(id);
        return new ResponseEntity<>(portada, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Portada> listar() {
        return portadaService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<Portada> editar(@RequestBody Portada portada){
        Portada editar = portadaService.editar(portada);
        return new ResponseEntity<>(editar,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<Portada> agregar(@RequestBody Portada portada){
        Portada nueva = portadaService.agregar(portada);
        return new ResponseEntity<>(nueva,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.portadaService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}

