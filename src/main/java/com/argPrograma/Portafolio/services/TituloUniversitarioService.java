package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.TituloUniversitario;
import com.argPrograma.Portafolio.repository.TituloUniversitarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class TituloUniversitarioService {
    private final TituloUniversitarioRepository tituloUniversitarioRepository;

    @Autowired
    public TituloUniversitarioService (TituloUniversitarioRepository tituloUniversitarioRepository){
        this.tituloUniversitarioRepository = tituloUniversitarioRepository;
    }

    public TituloUniversitario agregar(TituloUniversitario univ){
        return tituloUniversitarioRepository.save(univ);
    }

    public List<TituloUniversitario> listar(){
        return tituloUniversitarioRepository.findAll();
    }

    public TituloUniversitario editar(TituloUniversitario univ){
        return tituloUniversitarioRepository.save(univ);
    }

    public boolean eliminar(Long id){
        try{
            tituloUniversitarioRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public TituloUniversitario buscarPorId(Long id){
        return tituloUniversitarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Proyecto no encontrado"));
    }
}
