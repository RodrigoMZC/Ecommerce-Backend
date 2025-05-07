package com.rmr.ecommerce.domain.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{
    Optional<Inventario> findByProducto_Id(Long id);
    //Optional<Inventario> findByProducto_NombreIgnoreCase(String nombre);
    Optional<Inventario> findByProducto_NombreContainingIgnoreCase(String nombre);    
}
