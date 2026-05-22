package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.UnidadadminEntity;
import com.example.vSIAF.service.UnidadadminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Ejemplos para registrar una unidad administrativa",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo Potosí",
                                    summary = "Unidad administrativa de Potosí",
                                    value = """
                                            {
                                              "entidad": "Gobierno Autónomo Municipal",
                                              "unidad": "UA-101",
                                              "descripcion": "Unidad administrativa central",
                                              "ciudad": "Potosí"
                                            }
                                            """
                            ),
                            @ExampleObject(
                                    name = "Ejemplo Sucre",
                                    summary = "Unidad administrativa financiera",
                                    value = """
                                            {
                                              "entidad": "Gobernación Departamental",
                                              "unidad": "UA-202",
                                              "descripcion": "Unidad administrativa financiera",
                                              "ciudad": "Sucre"
                                            }
                                            """
                            )
                    }
            )
    )
    @PostMapping
    public UnidadadminEntity crear(@RequestBody UnidadadminEntity unidadAdmin) {
        return service.crear(unidadAdmin);
    }

    @Operation(
            summary = "Actualizar unidad administrativa",
            description = "Modifica una unidad administrativa existente"
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Ejemplos para actualizar una unidad administrativa",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    name = "Actualizar Potosí",
                                    summary = "Actualización de unidad central",
                                    value = """
                                            {
                                              "entidad": "Gobierno Autónomo Municipal",
                                              "unidad": "UA-101",
                                              "descripcion": "Unidad administrativa central actualizada",
                                              "ciudad": "Potosí"
                                            }
                                            """
                            ),
                            @ExampleObject(
                                    name = "Actualizar La Paz",
                                    summary = "Actualización de unidad financiera",
                                    value = """
                                            {
                                              "entidad": "Ministerio de Economía",
                                              "unidad": "UA-303",
                                              "descripcion": "Unidad financiera actualizada",
                                              "ciudad": "La Paz"
                                            }
                                            """
                            )
                    }
            )
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