package com.rmr.ecommerce.domain.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(
        name = "usuario_username",
        nullable = false,
        unique = true,
        length = 30
    )
    private String username;

    @Column(
        name = "usuario_password",
        nullable = false
    )
    private String password;

    @Column(
        name = "usuario_mail",
        nullable = false,
        unique = true,
        length = 100
    )
    private String mail;

    @Column(
        name = "usuario_telefono",
        nullable = true,
        unique = true,
        length = 10
    )
    private String telefono;

    @Column(
        name = "usuario_rfc",
        unique = true,
        nullable = true,
        length = 13
    )
    private String rfc;

    @Column(
        name = "usuario_nombre",
        nullable = false,
        length = 30
    )
    private String nombre;

    @Column(
        name = "usuario_segundoNombre",
        nullable = true,
        length = 30
    )
    private String segundoNombre;

    @Column(
        name = "usuario_primerApellido",
        nullable = false,
        length = 30
    )
    private String primerApellido;

    @Column(
        name = "usuario_segundoApellido",
        nullable = false,
        length = 30
    )
    private String segundoApellido;

    @Column(
        name = "usuario_fechaNacimineto",
        nullable = false
    )
    private LocalDate fechaNacimiento;

    @Column(
        name = "usuario_imgUrl",
        nullable = true
    )
    private String imgUrl;

    @Column(
        name = "usuario_estado",
        nullable = false    
    )
    private boolean estado;

    @Column(
        name = "usuario_fechaUltimoAcceso",
        nullable = false
    )
    private LocalDateTime fechaUltimoAcceso;

    @Column(
        name = "usuario_fechaCreacion",
        nullable = false,
        updatable = false
    )
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @OneToMany(
        mappedBy = "usuario",
        cascade = CascadeType.ALL,
        orphanRemoval = true    
    )
    private List<Direccion> direcciones = new ArrayList<>();

    @OneToMany(
        mappedBy = "usuario"
    )
    private List<Compra> compras;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();

    @Column(
        name = "usuario_verificado",
        nullable = false
    )
    private boolean verificado;

    @Column(
        name = "usuario_tokenVerificacion",
        nullable = true
    )
    private String tokenVerificacion;

    @Column(
        name = "usuario_fechaExporacionToken",
        nullable = true
    )
    private LocalDateTime fechaExpiracionToken;
}
