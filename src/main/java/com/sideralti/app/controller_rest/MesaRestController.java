package com.sideralti.app.controller_rest;

import com.sideralti.app.model.dto.MesaDTO;
import com.sideralti.app.service.MesaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest/mesas")
public class MesaRestController {

    private final MesaService mesaService;

    public MesaRestController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find mesa by ID")
    public ResponseEntity<MesaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mesaService.findById(id));
    }

    @GetMapping("/find-all")
    @Operation(summary = "Find all mesas")
    public ResponseEntity<List<MesaDTO>> findAll() {
        return ResponseEntity.ok(mesaService.findAll());
    }

    @PostMapping
    @Operation(summary = "Create new mesa")
    public ResponseEntity<MesaDTO> save(@Valid @RequestBody MesaDTO mesaDto) {
        MesaDTO savedMesa = mesaService.save(mesaDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMesa.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedMesa);
    }

    @PostMapping("/bulk")
    @Operation(summary = "Create multiple mesas")
    public ResponseEntity<List<MesaDTO>> saveAll(@Valid @RequestBody List<MesaDTO> mesaDtos) {
        List<MesaDTO> savedMesas = mesaService.saveAll(mesaDtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMesas);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update mesa by ID")
    public ResponseEntity<MesaDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody MesaDTO mesaDto) {
        return ResponseEntity.ok(mesaService.update(id, mesaDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete mesa by ID")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        mesaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-all")
    @Operation(summary = "Delete all mesas")
    public ResponseEntity<Void> deleteAll() {
        mesaService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    @Operation(summary = "Get total number of mesas")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(mesaService.count());
    }






}
