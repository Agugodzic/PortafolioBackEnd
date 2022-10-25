package com.argPrograma.Portafolio.services;
import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.Experiencia;
import com.argPrograma.Portafolio.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;

    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository){
        this.experienciaRepository = experienciaRepository;
    }
    public Experiencia agregar(Experiencia experiencia){
        return experienciaRepository.save(experiencia);
    }

    public List<Experiencia> listar(){
        return experienciaRepository.findAll();
    }

    public Experiencia editar(Experiencia experiencia){
        return experienciaRepository.save(experiencia);
    }

    public boolean eliminar(Long id){
        try {
            experienciaRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public Experiencia buscarPorId(Long id){

        return experienciaRepository.findById(id).orElseThrow(()-> new NotFoundException("Experiencia no encontrada"));
    }
}
