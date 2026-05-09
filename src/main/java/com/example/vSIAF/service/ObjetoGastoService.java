package com.example.vSIAF.service;

import com.example.vSIAF.entity.ObjetoGasto;
import com.example.vSIAF.repository.ObjetoGastoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetoGastoService {

    private final ObjetoGastoRepository repository;

    public ObjetoGastoService(ObjetoGastoRepository repository) {
        this.repository = repository;
    }

    // Listar todos
    public List<ObjetoGasto> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<ObjetoGasto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Guardar
    public ObjetoGasto guardar(ObjetoGasto objetoGasto) {
        return repository.save(objetoGasto);
    }

    // Eliminar
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}