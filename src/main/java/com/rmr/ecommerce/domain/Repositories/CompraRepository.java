package com.rmr.ecommerce.domain.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.Compra;
import com.rmr.ecommerce.domain.Model.Enum.EstadoCompra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
    List<Compra> findByUsuario_IdOrderByFechaDesc(Long id);
    List<Compra> findByEstado(EstadoCompra estadoCompra);
    boolean existsByUsuario_Id(Long id);
}
