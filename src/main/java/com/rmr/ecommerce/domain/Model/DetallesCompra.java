package com.rmr.ecommerce.domain.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
@Table(name = "detalles_compra")
public class DetallesCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalles_compra_id")
    private Long id;

    @ManyToOne
    @JoinColumn(
        name = "producto_id",
        nullable = false
    )
    private Producto producto;

    @ManyToOne
    @JoinColumn(
        name = "compra_id",
        nullable = false
    )
    private Compra compra;

    @Column(
        name = "detalles_compra_cantidad",
        nullable = false,
        updatable = false
    )
    private Integer cantidad = 1;

    @Column(
        name = "detalles_compra_precio",
        nullable = false,
        updatable = false
    )
    private BigDecimal precio;

    @Column(
        name = "detalles_compra_subtotal",
        nullable = false,
        updatable = false
    )
    private BigDecimal subtotal;

    @PrePersist
    public void CalcularSubtotal() {
        if (subtotal == null && cantidad != null && precio != null) {
            this.subtotal = precio.multiply(BigDecimal.valueOf(cantidad));
        }
    }
}
