package com.argPrograma.Portafolio.repository;

import com.argPrograma.Portafolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
  Optional <User> findByEmail(String email);
}
