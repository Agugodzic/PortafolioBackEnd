package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.FotoPerfil;
import com.argPrograma.Portafolio.services.FotoPerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/foto-perfil")
public class FotoPerfilController {
    private final FotoPerfilService fotoPerfilService;
    public FotoPerfilController(FotoPerfilService fotoPerfilService){
        this.fotoPerfilService=fotoPerfilService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoPerfil> buscarPorId(@PathVariable("id") Long id) {
        FotoPerfil foto = fotoPerfilService.buscarPorId(id);
        return new ResponseEntity<>(foto, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<FotoPerfil> listar() {
        return fotoPerfilService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<FotoPerfil> editar(@RequestBody FotoPerfil fotoPerfil){
        FotoPerfil editado = fotoPerfilService.editar(fotoPerfil);
        return new ResponseEntity<>(editado,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<FotoPerfil> agregar(@RequestBody FotoPerfil fotoPerfil){
        FotoPerfil nueva = fotoPerfilService.agregar(fotoPerfil);
        return new ResponseEntity<>(nueva,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.fotoPerfilService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
