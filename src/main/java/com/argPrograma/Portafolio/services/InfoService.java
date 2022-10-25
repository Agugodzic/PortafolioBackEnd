package com.argPrograma.Portafolio.services;
import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.Info;
import com.argPrograma.Portafolio.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class InfoService {
    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository){
        this.infoRepository = infoRepository;
    }

    public List<Info> listar(){ return infoRepository.findAll(); }

    public Info buscarPorId(Long id){
        return infoRepository.findById(id).orElseThrow(()-> new NotFoundException("Elemento no encontrado"));
    }

    public boolean eliminar(Long id){
        try{
            infoRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }
    public Info editar(Info info){
        return infoRepository.save(info);
    }

    public Info agregar(Info info){
        return infoRepository.save(info);
    }
}
