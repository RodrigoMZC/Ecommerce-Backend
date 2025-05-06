package com.rmr.ecommerce.domain.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{
    List<Direccion> findByUsuario_Id(Long id);
}
