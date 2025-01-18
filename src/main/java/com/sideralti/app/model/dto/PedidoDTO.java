package com.sideralti.app.model.dto;

import com.sideralti.app.model.enums.EstadoPedidoEnums;

import java.util.List;

public class PedidoDTO {

    private Long id;
    private Long mesaId;
    private String cliente;
    private List<Long> productoIds;
    private double total;
    private EstadoPedidoEnums estado;

    // Builder
    public static class Builder {
        private Long id;
        private Long mesaId;
        private String cliente;
        private List<Long> productoIds;
        private double total;
        private EstadoPedidoEnums estado;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder mesaId(Long mesaId) {
            this.mesaId = mesaId;
            return this;
        }

        public Builder cliente(String cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder productoIds(List<Long> productoIds) {
            this.productoIds = productoIds;
            return this;
        }

        public Builder total(double total) {
            this.total = total;
            return this;
        }

        public Builder estado(EstadoPedidoEnums estado) {
            this.estado = estado;
            return this;
        }

        public PedidoDTO build() {
            PedidoDTO dto = new PedidoDTO();
            dto.id = this.id;
            dto.mesaId = this.mesaId;
            dto.cliente = this.cliente;
            dto.productoIds = this.productoIds;
            dto.total = this.total;
            dto.estado = this.estado;
            return dto;
        }
    }
}

