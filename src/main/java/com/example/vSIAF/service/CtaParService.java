package com.example.vSIAF.service;

import com.example.vSIAF.entity.CtaParEntity;
import com.example.vSIAF.repository.CtaParRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CtaParService {

    private final CtaParRepository repository;

    public CtaParService(CtaParRepository repository) {
        this.repository = repository;
    }

    public List<CtaParEntity> listar() {
        return repository.findAll();
    }

    public CtaParEntity buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public CtaParEntity guardar(CtaParEntity ctapar) {
        return repository.save(ctapar);
    }

    public CtaParEntity actualizar(Integer id, CtaParEntity ctaparActualizado) {
        CtaParEntity ctapar = repository.findById(id).orElse(null);

        if (ctapar != null) {
            // Actualizamos los campos específicos de CtaPar
            ctapar.setCodcont(ctaparActualizado.getCodcont());
            ctapar.setGestion(ctaparActualizado.getGestion());
            return repository.save(ctapar);
        }

        return null;
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}