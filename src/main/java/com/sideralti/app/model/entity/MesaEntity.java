package com.sideralti.app.model.entity;

import com.sideralti.app.model.enums.EstadoMesaEnums;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "mesas")
public class MesaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoMesaEnums estado;


    // Constructor privado para Builder
    private MesaEntity(Builder builder) {
        this.id = builder.id;
        this.numero = builder.numero;
        this.capacidad = builder.capacidad;
        this.estado = builder.estado;
    }

    public MesaEntity() {}

    public MesaEntity(Long id, int numero, int capacidad, EstadoMesaEnums estado) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoMesaEnums getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesaEnums estado) {
        this.estado = estado;
    }

    // Implementación del patrón Builder
    public static class Builder {
        private Long id;
        private int numero;
        private int capacidad;
        private EstadoMesaEnums estado;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder numero(int numero) {
            this.numero = numero;
            return this;
        }

        public Builder capacidad(int capacidad) {
            this.capacidad = capacidad;
            return this;
        }

        public Builder estado(EstadoMesaEnums estado) {
            this.estado = estado;
            return this;
        }

        public MesaEntity build() {
            return new MesaEntity(this);
        }
    }

    @Override
    public String toString() {
        return "MesaEntity{" +
                "id=" + id +
                ", numero=" + numero +
                ", capacidad=" + capacidad +
                ", estado=" + estado +
                '}';
    }

}
