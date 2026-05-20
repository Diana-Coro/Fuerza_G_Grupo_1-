package com.example.vSIAF.Controller;

import com.example.vSIAF.model.UnidadAdmin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/unidadadmin")
@Tag(name = "UnidadAdmin API", description = "CRUD de la tabla Unidad Administrativa")
public class UnidadAdminController {

    private final List<UnidadAdmin> unidades = new ArrayList<>();

    public UnidadAdminController() {

        unidades.add(
                new UnidadAdmin(1L, 1L,
                        "Unidad administrativa", "Potosi")
        );
    }

    @Operation(
            summary = "Lista de unidades administrativas",
            description = "Obtiene todas las unidades administrativas registradas"
    )
    @GetMapping
    public List<UnidadAdmin> listar() {
        return unidades;
    }

    @Operation(
            summary = "Buscar unidad administrativa",
            description = "Obtiene una unidad administrativa mediante su código"
    )
    @GetMapping("/{unidad}")
    public UnidadAdmin buscar(@PathVariable Long unidad) {

        return unidades.stream()
                .filter(item -> item.getUnidad().equals(unidad))
                .findFirst()
                .orElse(null);
    }

    @Operation(
            summary = "Registrar unidad administrativa",
            description = "Agrega una nueva unidad administrativa"
    )
    @PostMapping
    public UnidadAdmin crear(@RequestBody UnidadAdmin unidadAdmin) {

        unidades.add(unidadAdmin);

        return unidadAdmin;
    }

    @Operation(
            summary = "Actualizar unidad administrativa",
            description = "Modifica una unidad administrativa existente"
    )
    @PutMapping("/{unidad}")
    public UnidadAdmin actualizar(@PathVariable Long unidad,
                                  @RequestBody UnidadAdmin unidadAdmin) {

        for (UnidadAdmin item : unidades) {

            if (item.getUnidad().equals(unidad)) {

                item.setEntidad(unidadAdmin.getEntidad());
                item.setUnidad(unidadAdmin.getUnidad());
                item.setDescrip(unidadAdmin.getDescrip());
                item.setCiudad(unidadAdmin.getCiudad());

                return item;
            }
        }

        return null;
    }

    @Operation(
            summary = "Eliminar unidad administrativa",
            description = "Elimina una unidad administrativa mediante su código"
    )
    @DeleteMapping("/{unidad}")
    public String eliminar(@PathVariable Long unidad) {

        unidades.removeIf(item -> item.getUnidad().equals(unidad));

        return "UnidadAdmin eliminada correctamente";
    }
}