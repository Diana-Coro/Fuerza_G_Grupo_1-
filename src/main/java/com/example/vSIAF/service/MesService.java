package com.example.vSIAF.service;

import com.example.vSIAF.entity.MesEntity;
import com.example.vSIAF.repository.MesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesService {

    private final MesRepository repository;

    public MesService(MesRepository repository) {
        this.repository = repository;
    }

    public List<MesEntity> listar() {
        return repository.findAll();
    }

    public MesEntity buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public MesEntity guardar(MesEntity mes) {
        return repository.save(mes);
    }

    public MesEntity actualizar(Integer id, MesEntity mesActualizado) {
        MesEntity mes = repository.findById(id).orElse(null);

        if (mes != null) {
            mes.setNommes(mesActualizado.getNommes());
            return repository.save(mes);
        }

        return null;
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}