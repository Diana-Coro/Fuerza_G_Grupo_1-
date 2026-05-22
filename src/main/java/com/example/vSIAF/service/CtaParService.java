package com.example.vSIAF.service;

import com.example.vSIAF.entity.CtaParEntity;
import com.example.vSIAF.repository.CtaParRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CtaParService {

    private final CtaParRepository repository;

    public CtaParService(CtaParRepository repository) {
        this.repository = repository;
    }

    public List<CtaParEntity> listar() {
        return repository.findAll();
    }

    public Optional<CtaParEntity> buscar(Integer id) {
        return repository.findById(id);
    }

    public CtaParEntity guardar(CtaParEntity ctapar) {
        return repository.save(ctapar);
    }

    public CtaParEntity actualizar(Integer id, CtaParEntity ctaparActualizado) {
        CtaParEntity ctapar = repository.findById(id).orElse(null);

        if (ctapar != null) {
            ctapar.setPartida(ctaparActualizado.getPartida());
            ctapar.setGestion(ctaparActualizado.getGestion());
            return repository.save(ctapar);
        }

        return null;
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}