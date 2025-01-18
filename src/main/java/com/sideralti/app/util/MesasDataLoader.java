package com.sideralti.app.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sideralti.app.model.entity.MesaEntity;
import com.sideralti.app.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.io.InputStream;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class MesasDataLoader implements CommandLineRunner {

    private MesaRepository mesaRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        TypeReference<List<MesaEntity>> typeReference = new TypeReference<List<MesaEntity>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/jason/data-templates.json");

        try {
            List<MesaEntity> entitiesList = mapper.readValue(inputStream, typeReference);
            mesaRepository.saveAll(entitiesList);
            System.out.println("Datos cargados exitosamente!");
        } catch (Exception e) {
            System.out.println("Error al cargar los datos iniciales: " + e.getMessage());
            throw e;
        }
    }
}