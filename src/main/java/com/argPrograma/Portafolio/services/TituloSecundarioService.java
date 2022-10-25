package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.TituloSecundario;
import com.argPrograma.Portafolio.repository.TituloSecundarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TituloSecundarioService {
    private final TituloSecundarioRepository tituloSecundarioRepository;

    @Autowired
    public TituloSecundarioService (TituloSecundarioRepository tituloSecundarioRepository){
        this.tituloSecundarioRepository = tituloSecundarioRepository;
    }

    public TituloSecundario agregar(TituloSecundario univ){
        return tituloSecundarioRepository.save(univ);
    }

    public List<TituloSecundario> listar(){
        return tituloSecundarioRepository.findAll();
    }

    public TituloSecundario editar(TituloSecundario univ){
        return tituloSecundarioRepository.save(univ);
    }

    public boolean eliminar(Long id){
        try{
            tituloSecundarioRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public TituloSecundario buscarPorId(Long id){
        return tituloSecundarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Proyecto no encontrado"));
    }
}
