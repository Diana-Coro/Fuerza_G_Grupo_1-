package com.example.vSIAF.service;

import com.example.vSIAF.entity.UnidadadminEntity;
import com.example.vSIAF.repository.UnidadadminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadadminService {

    private final UnidadadminRepository repository;

    public UnidadadminService(UnidadadminRepository repository) {
        this.repository = repository;
    }

    public List<UnidadadminEntity> listar() {
        return repository.findAll();
    }

    public UnidadadminEntity buscar(Long unidad) {
        return repository.findById(unidad).orElse(null);
    }

    public UnidadadminEntity crear(UnidadadminEntity unidadadmin) {
        return repository.save(unidadadmin);
    }

    public UnidadadminEntity actualizar(Long unidad, UnidadadminEntity unidadadmin) {
        UnidadadminEntity existente = repository.findById(unidad).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setEntidad(unidadadmin.getEntidad());
        existente.setDescrip(unidadadmin.getDescrip());
        existente.setCiudad(unidadadmin.getCiudad());

        return repository.save(existente);
    }

    public String eliminar(Long unidad) {
        repository.deleteById(unidad);
        return "Unidadadmin eliminada correctamente";
    }
}