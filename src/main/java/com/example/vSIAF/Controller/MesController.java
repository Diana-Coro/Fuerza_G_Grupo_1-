package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.MesEntity;
import com.example.vSIAF.service.MesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mes")
@Tag(name = "Mes API", description = "CRUD de la tabla Mes")
public class MesController {

    @Autowired
    private MesService mesService;

    @Operation(
            summary = "Listar meses",
            description = "Obtiene la lista completa de meses registrados en el sistema."
    )
    @GetMapping
    public List<MesEntity> listar() {
        return mesService.listar();
    }

    @Operation(
            summary = "Buscar mes por ID",
            description = "Obtiene un mes específico mediante su identificador."
    )
    @GetMapping("/{id}")
    public MesEntity buscarPorId(@PathVariable Integer id) {
        return mesService.buscarPorId(id);
    }

    @Operation(
            summary = "Registrar un mes",
            description = "Permite registrar un nuevo mes en la base de datos."
    )
    @PostMapping
    public MesEntity guardar(

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del mes a registrar",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "Mes": 1,
                                              "Nommes": "Enero"
                                            }
                                            """
                            )
                    )
            )

            @RequestBody MesEntity mes
    ) {
        return mesService.guardar(mes);
    }

    @Operation(
            summary = "Actualizar un mes",
            description = "Actualiza la información de un mes existente."
    )
    @PutMapping("/{id}")
    public MesEntity actualizar(
            @PathVariable Integer id,

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos actualizados del mes",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "Mes": 1,
                                              "Nommes": "Enero Actualizado"
                                            }
                                            """
                            )
                    )
            )

            @RequestBody MesEntity mes
    ) {
        return mesService.actualizar(id, mes);
    }

    @Operation(
            summary = "Eliminar un mes",
            description = "Elimina un mes registrado mediante su ID."
    )
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        mesService.eliminar(id);
    }
}