package com.rmr.ecommerce.domain.Model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer id;

    @Column(
        name = "categoria_nombre",
        nullable = false,
        unique = true,
        length = 30
    )
    private String nombre;

    @Column(
        name = "categoria_descripcion",
        nullable = true,
        columnDefinition = "TEXT"
    )
    private String descripcion;

    @ManyToMany(mappedBy = "categorias")
    private Set<Producto> productos = new HashSet<>();

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
