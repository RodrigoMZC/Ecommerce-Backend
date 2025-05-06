package com.rmr.ecommerce.domain.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmr.ecommerce.domain.Model.Compra;
import com.rmr.ecommerce.domain.Model.Enum.EstadoCompra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
    List<Compra> findByUsuario_IdOrderByFechaDesc(Long id);
    List<Compra> findVyEstado(EstadoCompra estadoCompra);
    boolean existByUsuario_Id(Long id);
}
