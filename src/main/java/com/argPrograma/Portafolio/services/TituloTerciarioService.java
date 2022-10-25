package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.TituloTerciario;
import com.argPrograma.Portafolio.model.UniversitarioEnCurso;
import com.argPrograma.Portafolio.repository.TituloTerciarioRepository;
import com.argPrograma.Portafolio.repository.UniversitarioEnCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TituloTerciarioService {
    private final TituloTerciarioRepository terciarioRepository;

    @Autowired
    public TituloTerciarioService (TituloTerciarioRepository terciarioRepository){
        this.terciarioRepository = terciarioRepository;
    }

    public TituloTerciario agregar(TituloTerciario terciario){
        return terciarioRepository.save(terciario);
    }

    public List<TituloTerciario> listar(){
        return terciarioRepository.findAll();
    }

    public TituloTerciario editar(TituloTerciario terciario){
        return terciarioRepository.save(terciario);
    }

    public boolean eliminar(Long id){
        try{
            terciarioRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public TituloTerciario buscarPorId(Long id){
        return terciarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Proyecto no encontrado"));
    }
}
