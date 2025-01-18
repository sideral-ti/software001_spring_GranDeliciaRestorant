package com.sideralti.app.mapper;

import com.sideralti.app.model.dto.MesaDTO;
import com.sideralti.app.model.entity.MesaEntity;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaDTO toDto(MesaEntity entity) {
        return new MesaDTO.Builder()
                .id(entity.getId())
                .numero(entity.getNumero())
                .capacidad(entity.getCapacidad())
                .estado(entity.getEstado())
                .build();
    }

    public MesaEntity toEntity(MesaDTO dto) {
        return new MesaEntity.Builder()
                .id(dto.getId())
                .numero(dto.getNumero())
                .capacidad(dto.getCapacidad())
                .estado(dto.getEstado())
                .build();
    }
}
