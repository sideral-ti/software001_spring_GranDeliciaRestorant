package com.sideralti.app.service.impl;

import com.sideralti.app.exceptions.MesaNotFoundException;
import com.sideralti.app.mapper.MesaMapper;
import com.sideralti.app.model.dto.MesaDTO;
import com.sideralti.app.model.entity.MesaEntity;
import com.sideralti.app.repository.MesaRepository;
import com.sideralti.app.service.MesaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MesaServiceImpl implements MesaService {

    private final MesaRepository mesaRepository;
    private final MesaMapper mesaMapper;

    public MesaServiceImpl(MesaRepository mesaRepository, MesaMapper mesaMapper) {
        this.mesaRepository = mesaRepository;
        this.mesaMapper = mesaMapper;
    }

    @Override
    public MesaDTO findById(Long id) {
        return mesaRepository.findById(id)
                .map(mesaMapper::toDto)
                .orElseThrow(() -> new MesaNotFoundException(id));
    }

    @Override
    public List<MesaDTO> findAll() {
        return mesaRepository.findAll().stream()
                .map(mesaMapper::toDto)
                .toList();
    }

    @Override
    public MesaDTO save(MesaDTO mesaDto) {
        MesaEntity mesaEntity = mesaMapper.toEntity(mesaDto);
        MesaEntity savedEntity = mesaRepository.save(mesaEntity);
        return mesaMapper.toDto(savedEntity);
    }

    @Override
    public MesaDTO update(Long id, MesaDTO mesaDto) {
        return mesaRepository.findById(id)
                .map(existingMesa -> {
                    MesaEntity updatedMesa = mesaMapper.toEntity(mesaDto);
                    updatedMesa.setId(id);
                    return mesaMapper.toDto(mesaRepository.save(updatedMesa));
                })
                .orElseThrow(() -> new MesaNotFoundException(id));
    }

    @Override
    public void deleteById(Long id) {
        if (!mesaRepository.existsById(id)) {
            throw new MesaNotFoundException(id);
        }
        mesaRepository.deleteById(id);
    }

    public List<MesaDTO> saveAll(List<MesaDTO> mesaDtos) {
        List<MesaEntity> entities = mesaDtos.stream()
                .map(mesaMapper::toEntity)
                .toList();

        List<MesaEntity> savedEntities = mesaRepository.saveAll(entities);

        return savedEntities.stream()
                .map(mesaMapper::toDto)
                .toList();
    }

    @Override
    public void deleteAll() {
        mesaRepository.deleteAll();
    }

    @Override
    public long count() {
        return mesaRepository.count();
    }

}
