package com.sideralti.app.service;

import com.sideralti.app.model.dto.MesaDTO;

import java.util.List;

public interface MesaService {

    MesaDTO findById(Long id);
    List<MesaDTO> findAll();
    MesaDTO save(MesaDTO mesaDto);
    MesaDTO update(Long id, MesaDTO mesaDto);
    void deleteById(Long id);
    List<MesaDTO> saveAll(List<MesaDTO> mesaDtos);
    void deleteAll();
    long count();
}
