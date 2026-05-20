package com.example.vSIAF.service;

import com.example.vSIAF.entity.UnidadAdminEntity;
import com.example.vSIAF.repository.UnidadAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadAdminService {

    private final UnidadAdminRepository repository;

    public UnidadAdminService(UnidadAdminRepository repository) {
        this.repository = repository;
    }

    public List<UnidadAdminEntity> listar() {
        return repository.findAll();
    }

    public UnidadAdminEntity buscar(Long unidad) {
        return repository.findById(unidad).orElse(null);
    }

    public UnidadAdminEntity crear(UnidadAdminEntity unidadAdmin) {
        return repository.save(unidadAdmin);
    }

    public UnidadAdminEntity actualizar(Long unidad, UnidadAdminEntity unidadAdmin) {
        UnidadAdminEntity existente = repository.findById(unidad).orElse(null);

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