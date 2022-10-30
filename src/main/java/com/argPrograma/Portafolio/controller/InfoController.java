package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.Info;
import com.argPrograma.Portafolio.services.InfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
@CrossOrigin("http://portafolio-frontend-f5c86.web.app")
public class InfoController {

    private final InfoService infoService;
    public InfoController(InfoService infoService){
        this.infoService=infoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Info> buscarPorId(@PathVariable("id") Long id) {
        Info info = infoService.buscarPorId(id);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Info> listar() {
        return infoService.listar();
    }

    @PutMapping("/agregar")
    public void agregar(Info info){
      infoService.agregar(info);
    }

    @PutMapping("/editar")
    public ResponseEntity<Info> editarInfo(@RequestBody Info info) {
        Info infoUsuario = infoService.editar(info);
        return new ResponseEntity<>(infoUsuario, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.infoService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }

}
