package com.rmr.ecommerce.domain.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrito_id")
    private Long id;

    @OneToOne
    @JoinColumn(
        name = "usuario_id",
        nullable = false
    )
    private Usuario usuario;

    @OneToMany(
        mappedBy = "carrito",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ItemCarrito> items;
}
