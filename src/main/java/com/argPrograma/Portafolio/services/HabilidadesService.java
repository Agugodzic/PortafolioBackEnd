package com.argPrograma.Portafolio.services;
import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.Experiencia;
import com.argPrograma.Portafolio.model.Habilidades;
import com.argPrograma.Portafolio.repository.HabilidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HabilidadesService {
    private final HabilidadesRepository habilidadesRepository;

    @Autowired
    public HabilidadesService(HabilidadesRepository habilidadesRepository){
        this.habilidadesRepository = habilidadesRepository;
    }
    public Habilidades agregar(Habilidades habilidad){
        return habilidadesRepository.save(habilidad);
    }

    public List<Habilidades> get(){ return habilidadesRepository.findAll();}

    public List<Habilidades> listar(){
        return habilidadesRepository.findAll();
    }

    public Habilidades editar(Habilidades habilidad){
        return habilidadesRepository.save(habilidad);
    }

    public boolean eliminar(Long id){
        try{
            habilidadesRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public Habilidades buscarPorId(Long id){
        return habilidadesRepository.findById(id).orElseThrow(()-> new NotFoundException("Habilidad no encontrada"));
    }
}
