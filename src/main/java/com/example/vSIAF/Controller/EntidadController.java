package com.example.vSIAF.Controller;

import com.example.vSIAF.model.EntidadModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EntidadController {

        private final List<EntidadModel> entidades = new ArrayList<>();

        @GetMapping("/entideades")
        public List<EntidadModel> getEntidades() {
            return entidades;
        }

        @GetMapping("/entidades/{entidad}")
        public EntidadModel getEntidadesByEntidad(@PathVariable long entidad) {
            return entidades.stream()
                    .filter(e -> e.getEntidad() == entidad)
                    .findFirst()
                    .orElse(null);
        }

        @PostMapping("/entidades")
        public EntidadModel postEntidades(@RequestBody EntidadModel nuevo) {
            entidades.add(nuevo);
            return nuevo;
        }

        @PutMapping("/entidades/{entidad}")
        public EntidadModel putEntidades(@PathVariable long entidad, @RequestBody EntidadModel editado) {
            EntidadModel temporal = entidades.stream()
                    .filter(e -> e.getEntidad() == entidad)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("ENTIDAD NO ENCONTRADA"));

            if (editado.getGestion() != 0) temporal.setGestion(editado.getGestion());
            if (editado.getEntidad() != 0) temporal.setEntidad(editado.getEntidad());
            if (editado.getDescripcion() != null) temporal.setDescripcion(editado.getDescripcion());
            if (editado.getSigla() != null) temporal.setSigla(editado.getSigla());

            return temporal;
        }

        @DeleteMapping("/entidades/{entidad}")
        public EntidadModel deleteEntidades(@PathVariable long entidad) {
            EntidadModel temporal = entidades.stream()
                    .filter(e -> e.getEntidad() == entidad)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("ENTIDAD NO ENCONTRADA"));

            entidades.remove(temporal);
            return temporal;
        }
    }

