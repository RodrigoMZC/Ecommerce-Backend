package com.rmr.ecommerce.domain.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.DetallesCompra;

@Repository
public interface DetallesCompraRepository extends JpaRepository<DetallesCompra, Long>{
    List<DetallesCompra> findByCompra_Id(Long id);
}
