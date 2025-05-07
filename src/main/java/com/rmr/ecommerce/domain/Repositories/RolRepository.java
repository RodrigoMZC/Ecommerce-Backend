package com.rmr.ecommerce.domain.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmr.ecommerce.domain.Model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
}
