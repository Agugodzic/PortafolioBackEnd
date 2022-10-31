package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.Experiencia;
import com.argPrograma.Portafolio.model.Habilidades;
import com.argPrograma.Portafolio.model.Usuario;
import com.argPrograma.Portafolio.services.HabilidadesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
@CrossOrigin("http://localhost:4200")
public class HabilidadesController {
    private final HabilidadesService habilidadesService;

    public HabilidadesController(HabilidadesService habilidadesService) {
        this.habilidadesService = habilidadesService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Habilidades> buscarPorId(@PathVariable("id") Long id) {
        Habilidades habilidad= habilidadesService.buscarPorId(id);
        return new ResponseEntity<>(habilidad, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Habilidades> listar() {
        return habilidadesService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<Habilidades> editar(@RequestBody Habilidades habilidad){
        Habilidades editarHabilidad = habilidadesService.editar(habilidad);
        return new ResponseEntity<>(editarHabilidad,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<Habilidades> agregar(@RequestBody Habilidades habilidad){
        Habilidades nuevaHabilidad = habilidadesService.agregar(habilidad);
        return new ResponseEntity<>(nuevaHabilidad,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.habilidadesService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
