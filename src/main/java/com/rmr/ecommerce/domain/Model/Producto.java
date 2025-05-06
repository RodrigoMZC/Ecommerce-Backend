package com.rmr.ecommerce.domain.Model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long id;

    @Column(
        name = "producto_nombre",
        nullable = false
    )
    private String nombre;

    @Column(
        name = "producto_descripcion",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String descripcion;

    @Column(
        name = "producto_precio",
        nullable = false
    )
    private BigDecimal precio;

    @Column(name = "producto_imgUrl")
    private String imgUrl;

    @ManyToMany
    @JoinTable(
        name = "producto_categoria", 
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>(); 

    @Column(
        name = "producto_fechaCreacion",
        nullable = false,
        updatable = false
    )
    private String fechaCreacion;

    @Column(
        name = "producto_fechaActualizacion",
        nullable = false
    )
    private String fechaActualizacion;
}
