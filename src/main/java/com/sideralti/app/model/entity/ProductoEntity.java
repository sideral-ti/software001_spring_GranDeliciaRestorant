package com.sideralti.app.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "productos")
public class ProductoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private double precio;
}
