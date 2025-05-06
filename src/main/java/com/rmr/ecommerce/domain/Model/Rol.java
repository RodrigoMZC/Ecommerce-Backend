package com.rmr.ecommerce.domain.Model;

import com.rmr.ecommerce.domain.Model.Enum.NombreRol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(
        name = "rol_nombre",
        nullable = false,
        unique = true,
        length = 30
    )
    private NombreRol nombre = NombreRol.CLIENTE;

    @Column(
        name = "rol_descripcion", 
        nullable = true,
        length = 100
    )
    private String descripcion;
}