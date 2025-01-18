package com.sideralti.app.model.dto;

import com.sideralti.app.model.enums.EstadoMesaEnums;

public class MesaDTO {
    private Long id;
    private int numero;
    private int capacidad;
    private EstadoMesaEnums estado;

    // Constructor vacío
    public MesaDTO() {
    }

    // Constructor privado para el Builder
    private MesaDTO(Builder builder) {
        this.id = builder.id;
        this.numero = builder.numero;
        this.capacidad = builder.capacidad;
        this.estado = builder.estado;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public EstadoMesaEnums getEstado() {
        return estado;
    }

    // Builder interno
    public static class Builder {
        private Long id;
        private int numero;
        private int capacidad;
        private EstadoMesaEnums estado;

        public Builder() {
        }

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

        public MesaDTO build() {
            return new MesaDTO(this);
        }
    }

    @Override
    public String toString() {
        return "MesaDTO{" +
                "id=" + id +
                ", numero=" + numero +
                ", capacidad=" + capacidad +
                ", estado=" + estado +
                '}';
    }
}
