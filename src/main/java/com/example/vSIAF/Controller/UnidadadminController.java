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
@Tag(name = "Unidadadmin API", description = "CRUD de la tabla Unidadadmin")
public class UnidadadminController {

    private final UnidadadminService service;

    public UnidadadminController(UnidadadminService service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista de unidadadmin",
            description = "Obtiene todas las unidades administrativas registradas"
    )
    @GetMapping
    public List<UnidadadminEntity> listar() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar unidadadmin",
            description = "Obtiene una unidad administrativa mediante su código"
    )
    @GetMapping("/{unidad}")
    public UnidadadminEntity buscar(@PathVariable Long unidad) {
        return service.buscar(unidad);
    }

    @Operation(
            summary = "Registrar unidadadmin",
            description = "Registra una nueva unidad administrativa"
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Ejemplo para registrar unidadadmin",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo Registro",
                                    summary = "Registro de unidadadmin",
                                    value = """
                                            {
                                              "entidad": 1,
                                              "unidad": 101,
                                              "descrip": "Unidad administrativa central",
                                              "ciudad": "Potosí"
                                            }
                                            """
                            )
                    }
            )
    )
    @PostMapping
    public UnidadadminEntity crear(@RequestBody UnidadadminEntity unidadadmin) {
        return service.crear(unidadadmin);
    }

    @Operation(
            summary = "Actualizar unidadadmin",
            description = "Modifica una unidad administrativa existente"
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Ejemplo para actualizar unidadadmin",
            required = true,
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo Actualización",
                                    summary = "Actualización de unidadadmin",
                                    value = """
                                            {
                                              "entidad": 1,
                                              "unidad": 101,
                                              "descrip": "Unidad administrativa actualizada",
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
            @RequestBody UnidadadminEntity unidadadmin
    ) {
        return service.actualizar(unidad, unidadadmin);
    }

    @Operation(
            summary = "Eliminar unidadadmin",
            description = "Elimina una unidad administrativa mediante su código"
    )
    @DeleteMapping("/{unidad}")
    public String eliminar(@PathVariable Long unidad) {
        return service.eliminar(unidad);
    }
}