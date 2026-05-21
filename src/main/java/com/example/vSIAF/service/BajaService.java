package com.example.vSIAF.service;

import com.example.vSIAF.entity.BajaEntity;
import com.example.vSIAF.repository.BajaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BajaService {

    private final BajaRepository repository;

    public BajaService(BajaRepository repository) {
        this.repository = repository;
    }

    public List<BajaEntity> listar() {
        return repository.findAll();
    }

    public BajaEntity buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public BajaEntity guardar(BajaEntity baja) {
        return repository.save(baja);
    }

    public BajaEntity actualizar(Long id, BajaEntity bajaActualizada) {
        BajaEntity baja = repository.findById(id).orElse(null);

        if (baja != null) {
            if (bajaActualizada.getDesbaja() != null) {
                baja.setDesbaja(bajaActualizada.getDesbaja());
            }
            return repository.save(baja);
        }

        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
