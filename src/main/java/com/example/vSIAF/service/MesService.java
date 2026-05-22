package com.example.vSIAF.service;

import com.example.vSIAF.entity.MesEntity;
import com.example.vSIAF.repository.MesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesService {

    @Autowired
    private MesRepository mesRepository;

    public List<MesEntity> listar() {
        return mesRepository.findAll();
    }

    public MesEntity buscarPorId(Integer id) {
        return mesRepository.findById(id).orElse(null);
    }

    public MesEntity guardar(MesEntity mes) {
        return mesRepository.save(mes);
    }

    public MesEntity actualizar(Integer id, MesEntity mes) {
        MesEntity existente = mesRepository.findById(id).orElse(null);

        if (existente != null) {
            existente.setNommes(mes.getNommes());
            return mesRepository.save(existente);
        }

        return null;
    }

    public void eliminar(Integer id) {
        mesRepository.deleteById(id);
    }
}