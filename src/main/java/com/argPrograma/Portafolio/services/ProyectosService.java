package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.Cursos;
import com.argPrograma.Portafolio.model.Proyectos;
import com.argPrograma.Portafolio.model.Usuario;
import com.argPrograma.Portafolio.repository.CursosRepository;
import com.argPrograma.Portafolio.repository.ProyectosRepository;
import com.argPrograma.Portafolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProyectosService{
    private final ProyectosRepository proyectosRepository;

    @Autowired
    public ProyectosService(ProyectosRepository proyectosRepository){
        this.proyectosRepository = proyectosRepository;
    }

    public Proyectos agregar(Proyectos proyecto){
        return proyectosRepository.save(proyecto);
    }

    public List<Proyectos> listar(){
        return proyectosRepository.findAll();
    }

    public Proyectos editar(Proyectos proyecto){
        return proyectosRepository.save(proyecto);
    }

    public boolean eliminar(Long id){
        try{
            proyectosRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public Proyectos buscarPorId(Long id){
        return proyectosRepository.findById(id).orElseThrow(()-> new NotFoundException("Proyecto no encontrado"));
    }
}

