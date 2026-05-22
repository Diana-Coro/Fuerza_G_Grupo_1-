package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.UnidadadminEntity;
import com.example.vSIAF.service.UnidadadminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadadmin")
@Tag(name = "UnidadAdmin API", description = "CRUD de la tabla Unidad Administrativa")
public class UnidadadminController {

    private final UnidadadminService service;

    public UnidadadminController(UnidadadminService service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista de unidades administrativas",
            description = "Obtiene todas las unidades administrativas registradas"
    )
    @GetMapping
    public List<UnidadadminEntity> listar() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar unidad administrativa",
            description = "Obtiene una unidad administrativa mediante su código"
    )
    @GetMapping("/{unidad}")
    public UnidadadminEntity buscar(@PathVariable Long unidad) {
        return service.buscar(unidad);
    }

    @Operation(
            summary = "Registrar unidad administrativa",
            description = "Registra una nueva unidad administrativa"
    )
    @PostMapping
    public UnidadadminEntity crear(@RequestBody UnidadadminEntity unidadAdmin) {
        return service.crear(unidadAdmin);
    }

    @Operation(
            summary = "Actualizar unidad administrativa",
            description = "Modifica una unidad administrativa existente"
    )
    @PutMapping("/{unidad}")
    public UnidadadminEntity actualizar(
            @PathVariable Long unidad,
            @RequestBody UnidadadminEntity unidadAdmin
    ) {
        return service.actualizar(unidad, unidadAdmin);
    }

    @Operation(
            summary = "Eliminar unidad administrativa",
            description = "Elimina una unidad administrativa mediante su código"
    )
    @DeleteMapping("/{unidad}")
    public String eliminar(@PathVariable Long unidad) {
        return service.eliminar(unidad);
    }
}