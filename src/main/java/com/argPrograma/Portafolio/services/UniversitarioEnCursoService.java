package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.UniversitarioEnCurso;
import com.argPrograma.Portafolio.repository.UniversitarioEnCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UniversitarioEnCursoService {

    private final UniversitarioEnCursoRepository universitarioEnCursoRepository;

    @Autowired
    public UniversitarioEnCursoService(UniversitarioEnCursoRepository universitarioEnCursoRepository){
        this.universitarioEnCursoRepository = universitarioEnCursoRepository;
    }

    public UniversitarioEnCurso agregar(UniversitarioEnCurso univ){
        return universitarioEnCursoRepository.save(univ);
    }

    public List<UniversitarioEnCurso> listar(){
        return universitarioEnCursoRepository.findAll();
    }

    public UniversitarioEnCurso editar(UniversitarioEnCurso univ){
        return universitarioEnCursoRepository.save(univ);
    }

    public boolean eliminar(Long id){
        try{
            universitarioEnCursoRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public UniversitarioEnCurso buscarPorId(Long id){
        return universitarioEnCursoRepository.findById(id).orElseThrow(()-> new NotFoundException("Proyecto no encontrado"));
    }
}
