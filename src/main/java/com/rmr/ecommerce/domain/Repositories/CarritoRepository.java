package com.rmr.ecommerce.domain.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmr.ecommerce.domain.Model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
    Optional<Carrito> findByUsuario_Id(Long id);
}
