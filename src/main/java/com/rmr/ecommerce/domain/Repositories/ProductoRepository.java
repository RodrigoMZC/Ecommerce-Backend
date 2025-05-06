package com.rmr.ecommerce.domain.Repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByCategorias_Id(Integer id);
    //List<Producto> findByCategorias_NombreContainingIgnoreCase(String nombre);
    boolean existByNombre(String nombre);
    List<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);
}
