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

    public UnidadadminEntity crear(UnidadadminEntity unidadAdmin) {
        return repository.save(unidadAdmin);
    }

    public UnidadadminEntity actualizar(Long unidad, UnidadadminEntity unidadAdmin) {
        UnidadadminEntity existente = repository.findById(unidad).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setEntidad(unidadAdmin.getEntidad());
        existente.setDescrip(unidadAdmin.getDescrip());
        existente.setCiudad(unidadAdmin.getCiudad());

        return repository.save(existente);
    }

    public String eliminar(Long unidad) {
        repository.deleteById(unidad);
        return "Unidad administrativa eliminada correctamente";
    }
}