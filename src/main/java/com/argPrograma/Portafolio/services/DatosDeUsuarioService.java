package com.argPrograma.Portafolio.services;
import com.argPrograma.Portafolio.model.DatosDeUsuario;
import com.argPrograma.Portafolio.repository.DatosDeUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DatosDeUsuarioService {
    private final DatosDeUsuarioRepository datosDeUsuarioRepository;

    @Autowired
    public DatosDeUsuarioService(DatosDeUsuarioRepository datosDeUsuarioRepository){
        this.datosDeUsuarioRepository = datosDeUsuarioRepository;
    }
    public DatosDeUsuario agregar(DatosDeUsuario datos){
        return datosDeUsuarioRepository.save(datos);
    }

    public List<DatosDeUsuario> listar(){
        return datosDeUsuarioRepository.findAll();
    }

    public DatosDeUsuario editar(DatosDeUsuario datos){
        return datosDeUsuarioRepository.save(datos);
    }

    public boolean eliminar(Long id){
        try {
            datosDeUsuarioRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }
}
