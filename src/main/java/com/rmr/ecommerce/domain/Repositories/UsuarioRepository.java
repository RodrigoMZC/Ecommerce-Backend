package com.rmr.ecommerce.domain.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByMail(String email);    
    boolean existsByUsername(String username);
}
