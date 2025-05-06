package com.rmr.ecommerce.domain.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "item_carrito")
public class ItemCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_carrito_id")
    private Long id;

    @ManyToOne
    @JoinColumn(
        name = "producto_id",
        nullable = false
    )
    private Producto producto;

    @ManyToOne
    @JoinColumn(
        name = "carrito_id",
        nullable = false
    )
    private Carrito carrito;

    @Column(
        name = "carrito_cantidad",
        nullable = false
    )
    private Integer cantidad = 1;
}
