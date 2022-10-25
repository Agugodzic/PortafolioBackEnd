package com.argPrograma.Portafolio.services;

import com.argPrograma.Portafolio.Exception.NotFoundException;
import com.argPrograma.Portafolio.model.Usuario;
import com.argPrograma.Portafolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario agregar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario editar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public boolean eliminar(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Error err){
            return false;
        }
    }
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));
    }
}
