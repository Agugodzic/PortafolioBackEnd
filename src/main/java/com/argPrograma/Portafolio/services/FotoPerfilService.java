package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.FotoPerfil;
import com.argPrograma.Portafolio.repository.FotoPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class FotoPerfilService {
    private final FotoPerfilRepository fotoPerfilRepository;

    @Autowired
    public FotoPerfilService(FotoPerfilRepository fotoPerfilRepository){
        this.fotoPerfilRepository = fotoPerfilRepository;
    }

    public FotoPerfil agregar(FotoPerfil fotoPerfil){
        return fotoPerfilRepository.save(fotoPerfil);
    }

    public List<FotoPerfil> listar(){
        return fotoPerfilRepository.findAll();
    }

    public FotoPerfil editar(FotoPerfil fotoPerfil){
        return fotoPerfilRepository.save(fotoPerfil);
    }

    public boolean eliminar(Long id){
        try{
            fotoPerfilRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }

    public FotoPerfil buscarPorId(Long id){
        return fotoPerfilRepository.findById(id).orElseThrow(()-> new NotFoundException("Elemento no encontrado"));
    }
}
