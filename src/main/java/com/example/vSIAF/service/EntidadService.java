package com.example.vSIAF.service;

import com.example.vSIAF.entity.EntidadEntity;
import com.example.vSIAF.repository.EntidadRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntidadService {

    private final EntidadRepository repository;

    // Inyección por constructor igual que el código de tu grupo
    public EntidadService(EntidadRepository repository) {
        this.repository = repository;
    }

    public List<EntidadEntity> listar() {
        return repository.findAll();
    }

    public EntidadEntity buscar(long id) {
        return repository.findById(id).orElse(null);
    }

    public EntidadEntity guardar(EntidadEntity entidad) {
        return repository.save(entidad);
    }

    public EntidadEntity actualizar(long id, EntidadEntity editado) {
        EntidadEntity temporal = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ENTIDAD NO ENCONTRADA"));

        if (editado.getGestion() != 0) temporal.setGestion(editado.getGestion());
        if (editado.getEntidad() != 0) temporal.setEntidad(editado.getEntidad());
        if (editado.getDescripcion() != null) temporal.setDescripcion(editado.getDescripcion());
        if (editado.getSigla() != null) temporal.setSigla(editado.getSigla());

        return repository.save(temporal);
    }

    public void eliminar(long id) {
        EntidadEntity temporal = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ENTIDAD NO ENCONTRADA"));
        repository.delete(temporal);
    }
}
