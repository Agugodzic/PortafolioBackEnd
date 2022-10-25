package com.argPrograma.Portafolio.repository;

import com.argPrograma.Portafolio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
