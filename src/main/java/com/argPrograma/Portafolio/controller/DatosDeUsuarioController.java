package com.argPrograma.Portafolio.controller;

import com.argPrograma.Portafolio.model.DatosDeUsuario;
import com.argPrograma.Portafolio.services.DatosDeUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datos")
@CrossOrigin("http://localhost:4200")
public class DatosDeUsuarioController {
    private final DatosDeUsuarioService datosDeUsuarioService;

    public DatosDeUsuarioController(DatosDeUsuarioService datosDeUsuarioService){
        this.datosDeUsuarioService=datosDeUsuarioService;
    }

    @GetMapping("/listar")
    public List<DatosDeUsuario> listar() {
        return datosDeUsuarioService.listar();
    }

    @PutMapping("/editar")
    public ResponseEntity<DatosDeUsuario> editar(@RequestBody DatosDeUsuario datos){
        DatosDeUsuario editarDatos= datosDeUsuarioService.editar(datos);
        return new ResponseEntity<>(editarDatos,HttpStatus.OK);
    }

    @PutMapping("/agregar")
    public ResponseEntity<DatosDeUsuario> agregar(@RequestBody DatosDeUsuario datos){
        DatosDeUsuario agregarDatos = datosDeUsuarioService.agregar(datos);
        return new ResponseEntity<>(agregarDatos,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.datosDeUsuarioService.eliminar(id);
        if(ok) {
            return "El elemento se elimino correctamente";
        }else{
            return "No se pudo eliminar el elemento.";
        }
    }
}
