package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.Portada;
import com.argPrograma.Portafolio.repository.PortadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PortadaService {
    private final PortadaRepository portadaRepository;

    @Autowired
    public PortadaService(PortadaRepository portadaRepository){
        this.portadaRepository = portadaRepository;
    }

    public Portada agregar(Portada portada){
        return portadaRepository.save(portada);
    }

    public List<Portada> listar(){
        return portadaRepository.findAll();
    }

    public Portada editar(Portada portada){
        return portadaRepository.save(portada);
    }

    public boolean eliminar(Long id){
        try{
            portadaRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public Portada buscarPorId(Long id){
        return portadaRepository.findById(id).orElseThrow(()-> new NotFoundException("Elemento no encontrado"));
    }
}
