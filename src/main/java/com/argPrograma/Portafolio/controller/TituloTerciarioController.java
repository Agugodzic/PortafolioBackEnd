package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.TituloSecundario;
import com.argPrograma.Portafolio.model.TituloTerciario;
import com.argPrograma.Portafolio.model.TituloUniversitario;
import com.argPrograma.Portafolio.services.TituloTerciarioService;
import com.argPrograma.Portafolio.services.TituloUniversitarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titulo-terciario")
@CrossOrigin("http://portafolio-frontend-f5c86.web.app")
public class TituloTerciarioController {
    private final TituloTerciarioService tituloTerciarioService;
    public TituloTerciarioController(TituloTerciarioService tituloTerciarioService){
        this.tituloTerciarioService = tituloTerciarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TituloTerciario> buscarPorId(@PathVariable("id") Long id) {
        TituloTerciario titulo = tituloTerciarioService.buscarPorId(id);
        return new ResponseEntity<>(titulo, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<TituloTerciario> listar() {
        return tituloTerciarioService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<TituloTerciario> editar(@RequestBody TituloTerciario titulo){
        TituloTerciario editado = tituloTerciarioService.editar(titulo);
        return new ResponseEntity<>(editado,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<TituloTerciario> agregar(@RequestBody TituloTerciario titulo) {
        TituloTerciario editado = tituloTerciarioService.editar(titulo);
        return new ResponseEntity<>(editado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.tituloTerciarioService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
