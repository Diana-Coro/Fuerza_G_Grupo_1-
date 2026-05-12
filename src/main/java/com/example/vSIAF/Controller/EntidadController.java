package com.example.vSIAF.Controller;

import com.example.vSIAF.model.Entidad;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EntidadController {

    private final List<Entidad> entidades = new ArrayList<>();

    @GetMapping("/entidades")
    public List<Entidad> getEntidades() {
        return entidades;
    }

    @GetMapping("/entidades/{entidad}")
    public Entidad getEntidadesByEntidad(@PathVariable long entidad) {

        return entidades.stream()
                .filter(e -> e.getEntidad() == entidad)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/entidades")
    public Entidad postEntidades(@RequestBody Entidad nuevo) {

        entidades.add(nuevo);

        return nuevo;
    }

    @PutMapping("/entidades/{entidad}")
    public Entidad putEntidades(@PathVariable long entidad,
                                @RequestBody Entidad editado) {

        Entidad temporal = entidades.stream()
                .filter(e -> e.getEntidad() == entidad)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ENTIDAD NO ENCONTRADA"));

        if (editado.getGestion() != 0)
            temporal.setGestion(editado.getGestion());

        if (editado.getEntidad() != 0)
            temporal.setEntidad(editado.getEntidad());

        if (editado.getDescripcion() != null)
            temporal.setDescripcion(editado.getDescripcion());

        if (editado.getSigla() != null)
            temporal.setSigla(editado.getSigla());

        return temporal;
    }

    @DeleteMapping("/entidades/{entidad}")
    public Entidad deleteEntidades(@PathVariable long entidad) {

        Entidad temporal = entidades.stream()
                .filter(e -> e.getEntidad() == entidad)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ENTIDAD NO ENCONTRADA"));

        entidades.remove(temporal);

        return temporal;
    }
}