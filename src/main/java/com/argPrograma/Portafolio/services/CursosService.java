package com.argPrograma.Portafolio.services;
import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.Cursos;
import com.argPrograma.Portafolio.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CursosService {
    private final CursosRepository cursosRepository;

    @Autowired
    public CursosService(CursosRepository cursosRepository){
        this.cursosRepository = cursosRepository;
    }

    public Cursos agregar(Cursos curso){
        return cursosRepository.save(curso);
    }

    public List<Cursos> listar(){
        return cursosRepository.findAll();
    }

    public Cursos editar(Cursos curso){
        return cursosRepository.save(curso);
    }

    public boolean eliminar(Long id){
        try{
            cursosRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public Cursos buscarPorId(Long id){
        return cursosRepository.findById(id).orElseThrow(()-> new NotFoundException("Proyecto no encontrado"));
    }
}
