package com.rmr.ecommerce.domain.Model;

import java.time.LocalDateTime;

import com.rmr.ecommerce.domain.Model.Enum.EstadoCompra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long id;
    
    @Column(
        name = "compra_fecha",
        nullable = false,
        updatable = false
    )
    private LocalDateTime fecha;

    @Column(
        name = "compra_total",
        nullable = false
    )
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(
        name = "compra_estado",
        nullable = false
    )
    private EstadoCompra estado = EstadoCompra.PENDIENTE;

    @ManyToOne
    @JoinColumn(
        name = "usuario_Id",
        nullable = false
    )
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(
        name = "direccion_id",
        nullable = false
    )
    private Direccion direccion;

    @Column(
        name = "Compra_metodoPago",
        nullable = false,
        updatable = false
    )
    private String metodoPago;

    @Column(
        name = "compra_numeroFactura",
        nullable = true
    )
    private String numeroFactura;

    @PrePersist
    public void setFechaActual() {
        this.fecha = LocalDateTime.now();
    }
}