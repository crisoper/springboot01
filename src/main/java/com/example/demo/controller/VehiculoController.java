package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VehiculoDTO;
import com.example.demo.model.Vehiculo;
import com.example.demo.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

	private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    // Return all data (200 OK)
    @GetMapping
    public ResponseEntity<Page<Vehiculo>> getAll(
    			Pageable pageable
    		) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    // Retorna un vehículo por ID (200 OK o 404 NOT FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getById(@PathVariable Integer id) {

        Vehiculo vehiculo = service.findById(id);

        if (vehiculo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehiculo);
    }

    // Crea un nuevo vehículo (201 CREATED)
    @PostMapping
    public ResponseEntity<Vehiculo> create(
            @RequestBody VehiculoDTO dto) {

        Vehiculo vehiculo = service.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehiculo);
    }

    // Actualiza un vehículo (200 OK o 404 NOT FOUND)
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> update(
            @PathVariable Integer id,
            @RequestBody VehiculoDTO dto) {

        Vehiculo vehiculo = service.update(id, dto);

        if (vehiculo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehiculo);
    }

    // Elimina un Vehiculo (204 NO CONTENT o 404 NOT FOUND)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        boolean eliminado = service.delete(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
	
}
