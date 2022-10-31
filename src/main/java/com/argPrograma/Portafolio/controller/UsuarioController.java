package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.Proyectos;
import com.argPrograma.Portafolio.model.Usuario;
import com.argPrograma.Portafolio.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("https://portafolio-frontend-f5c86.web.app")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
         this.usuarioService=usuarioService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @PutMapping("/agregar")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.agregar(usuario);
        return new ResponseEntity<>(nuevoUsuario,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminar(id);
        if(ok) {
            return "El elemento se borro correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.agregar(usuario);
        return new ResponseEntity<>(nuevoUsuario,HttpStatus.OK);
    }

}

