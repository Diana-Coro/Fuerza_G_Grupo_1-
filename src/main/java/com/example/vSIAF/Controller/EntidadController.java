package com.example.vSIAF.Controller;

import com.example.vSIAF.model.Entidad;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Entidad API", description = "CRUD de la tabla Entidad")
public class EntidadController {

    private final List<Entidad> entidades = new ArrayList<>();

    @Operation(
            summary = "Lista de entidades",
            description = "Obtiene todas las entidades registradas"
    )
    @GetMapping("/entidades")
    public List<Entidad> getEntidades() {
        return entidades;
    }

    @Operation(
            summary = "Buscar entidad por código",
            description = "Obtiene una entidad específica mediante su código"
    )
    @GetMapping("/entidades/{entidad}")
    public Entidad getEntidadesByEntidad(@PathVariable long entidad) {

        return entidades.stream()
                .filter(e -> e.getEntidad() == entidad)
                .findFirst()
                .orElse(null);
    }

    @Operation(
            summary = "Registrar entidad",
            description = "Agrega una nueva entidad al sistema"
    )
    @PostMapping("/entidades")
    public Entidad postEntidades(@RequestBody Entidad nuevo) {

        entidades.add(nuevo);

        return nuevo;
    }

    @Operation(
            summary = "Actualizar entidad",
            description = "Modifica los datos de una entidad existente"
    )
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

    @Operation(
            summary = "Eliminar entidad",
            description = "Elimina una entidad mediante su código"
    )
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