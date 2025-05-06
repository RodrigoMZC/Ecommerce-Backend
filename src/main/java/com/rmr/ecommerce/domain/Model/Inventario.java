package com.rmr.ecommerce.domain.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventario_id")
    private Integer id;

    @OneToOne
    @JoinColumn(
        name = "inventario_productoId",
        nullable = false,
        unique = true
    )
    private Producto producto;

    @Column(
        name = "inventario_cantidad",
        nullable = false
    )
    private Integer cantidad;

    @Column(
        name = "inventario_costo",
        nullable = false
    )
    private BigDecimal costo;

    @Column(
        name = "producto_fechaCreacion",
        nullable = false,
        updatable = false
    )
    private LocalDateTime fechaCreacion;

    @Column(
        name = "producto_fechaUltimaActualizacion",
        nullable = false
    )
    private LocalDateTime fechaUltimaActualizacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaUltimaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaUltimaActualizacion = LocalDateTime.now();
    }
}
