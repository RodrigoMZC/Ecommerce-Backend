package com.rmr.ecommerce.domain.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    Optional<Categoria> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
