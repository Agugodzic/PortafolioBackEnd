package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.TituloSecundario;
import com.argPrograma.Portafolio.services.TituloSecundarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titulo-secundario")
@CrossOrigin("https://portafolio-frontend-f5c86.web.app/")
public class TituloSecundarioController {
    private final TituloSecundarioService tituloSecundarioService;
    public TituloSecundarioController(TituloSecundarioService tituloSecundarioService){
        this.tituloSecundarioService=tituloSecundarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TituloSecundario> buscarPorId(@PathVariable("id") Long id) {
        TituloSecundario curso = tituloSecundarioService.buscarPorId(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<TituloSecundario> listar() {
        return tituloSecundarioService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<TituloSecundario> editar(@RequestBody TituloSecundario secundario){
        TituloSecundario editado = tituloSecundarioService.editar(secundario);
        return new ResponseEntity<>(editado,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<TituloSecundario> agregar(@RequestBody TituloSecundario secundario) {
        TituloSecundario editado = tituloSecundarioService.editar(secundario);
        return new ResponseEntity<>(editado, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.tituloSecundarioService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
