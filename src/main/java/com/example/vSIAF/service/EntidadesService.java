package com.example.vSIAF.service;

import com.example.vSIAF.entity.EntidadesEntity;
import com.example.vSIAF.repository.EntidadesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntidadesService {

        private final EntidadesRepository repository;

        public EntidadesService(EntidadesRepository repository) {
            this.repository = repository;
        }

        public List<EntidadesEntity> listar() {
            return repository.findAll();
        }

        public EntidadesEntity buscar(Integer id) {
            return repository.findById(id).orElse(null);
        }

        public EntidadesEntity guardar(EntidadesEntity entidad) {
            return repository.save(entidad);
        }

        public EntidadesEntity actualizar(Integer id, EntidadesEntity entidadActualizada) {
            EntidadesEntity entidad = repository.findById(id).orElse(null);

            if (entidad != null) {
                entidad.setGestion(entidadActualizada.getGestion());
                entidad.setDesc_ent(entidadActualizada.getDesc_ent());
                entidad.setSigla_ent(entidadActualizada.getSigla_ent());
                entidad.setSector_ent(entidadActualizada.getSector_ent());
                entidad.setSubsec_ent(entidadActualizada.getSubsec_ent());
                entidad.setArea_ent(entidadActualizada.getArea_ent());
                entidad.setSubareaent(entidadActualizada.getSubareaent());
                entidad.setNivel_inst(entidadActualizada.getNivel_inst());

                return repository.save(entidad);
            }

            return null;
        }

        public void eliminar(Integer id) {
            repository.deleteById(id);
        }
}

