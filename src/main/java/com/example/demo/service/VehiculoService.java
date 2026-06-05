package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.VehiculoDTO;
import com.example.demo.model.Vehiculo;
import com.example.demo.repository.VehiculoRepository;

@Service
public class VehiculoService {
	
	private final VehiculoRepository repo;

    public VehiculoService(VehiculoRepository repo) {
        this.repo = repo;
    }

    // Obtiene todos los vehículos registrados
    public List<Vehiculo> findAll() {
        return repo.findAll();
    }

    // Obtenemos lista paginada de registros
    public Page<Vehiculo> findAll(Pageable pageable) {
    	return repo.findAll(pageable);
    }
    
    // Busca un vehículo por ID
    public Vehiculo findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    // Crea un nuevo vehículo
    public Vehiculo create(VehiculoDTO dto) {

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setDescripcion(dto.getDescripcion());
        vehiculo.setSerie(dto.getSerie());
        vehiculo.setFechacompra(dto.getFechacompra());
        vehiculo.setMarca(dto.getMarca());

        return repo.save(vehiculo);
    }

    // Actualiza un vehículo existente
    public Vehiculo update(Integer id, VehiculoDTO dto) {

        Vehiculo vehiculo = repo.findById(id).orElse(null);

        if (vehiculo == null) {
            return null;
        }

        vehiculo.setDescripcion(dto.getDescripcion());
        vehiculo.setSerie(dto.getSerie());
        vehiculo.setFechacompra(dto.getFechacompra());
        vehiculo.setMarca(dto.getMarca());

        return repo.save(vehiculo);
    }

    // Elimina un vehículo por ID
    public boolean delete(Integer id) {

        if (!repo.existsById(id)) {
            return false;
        }

        repo.deleteById(id);
        return true;
    }
    
}
