package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.UnidadAdminEntity;
import com.example.vSIAF.service.UnidadAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadadmin")
@Tag(name = "UnidadAdmin API", description = "CRUD de la tabla Unidad Administrativa")
public class UnidadAdminController {

    private final UnidadAdminService service;

    public UnidadAdminController(UnidadAdminService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de unidades administrativas")
    @GetMapping
    public List<UnidadAdminEntity> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar unidad administrativa por código")
    @GetMapping("/{unidad}")
    public UnidadAdminEntity buscar(@PathVariable Long unidad) {
        return service.buscar(unidad);
    }

    @Operation(summary = "Registrar unidad administrativa")
    @PostMapping
    public UnidadAdminEntity crear(@RequestBody UnidadAdminEntity unidadAdmin) {
        return service.crear(unidadAdmin);
    }

    @Operation(summary = "Actualizar unidad administrativa")
    @PutMapping("/{unidad}")
    public UnidadAdminEntity actualizar(
            @PathVariable Long unidad,
            @RequestBody UnidadAdminEntity unidadAdmin
    ) {
        return service.actualizar(unidad, unidadAdmin);
    }

    @Operation(summary = "Eliminar unidad administrativa")
    @DeleteMapping("/{unidad}")
    public String eliminar(@PathVariable Long unidad) {
        return service.eliminar(unidad);
    }
}