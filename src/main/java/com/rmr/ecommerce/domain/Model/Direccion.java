package com.rmr.ecommerce.domain.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private Long id;

    @Column(
        name = "direccion_pais",
        nullable = false,
        length = 50
    )
    private String pais;

    @Column(
        name = "direccion_estado",
        nullable = false,
        length = 50
    )
    private String estado;

    @Column(
        name = "direccion_ciudad",
        nullable = false,
        length = 50
    )
    private String ciudad;
    @Column(
        name = "direccion_codigoPostal",
        nullable = false,
        length = 10
    )
    private String codigoPostal;

    @Column(
        name = "direccion_direccion",
        nullable = false,
        length = 100
    )
    private String direccion;

    @Column(
        name = "direccion_referencia",
        nullable = true,
        length = 100
    )
    private String referencia;

    @OneToMany(
        mappedBy = "direccion"
    )
    private List<Compra> compras;

    @ManyToOne
    @JoinColumn(
        name = "usuario_id",
        nullable = false
    )
    private Usuario usuario;
}
