package com.example.vSIAF.service;

import com.example.vSIAF.entity.EstadoEntity;
import com.example.vSIAF.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository repository;

    public EstadoService(EstadoRepository repository) {
        this.repository = repository;
    }


    public List<EstadoEntity> listar() {
        return repository.findAll();
    }


    public Optional<EstadoEntity> buscar(Integer id) {
        return repository.findById(id);
    }


    public EstadoEntity guardar(EstadoEntity estado) {
        return repository.save(estado);
    }


    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
