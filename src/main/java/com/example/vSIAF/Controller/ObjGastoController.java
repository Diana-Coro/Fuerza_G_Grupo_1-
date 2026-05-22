package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.ObjGastoEntity;
import com.example.vSIAF.service.ObjGastoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objgasto")
@Tag(name = "ObjGasto API", description = "CRUD de la tabla ObjGasto")
public class ObjGastoController {

    private final ObjGastoService service;

    public ObjGastoController(ObjGastoService service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista de objetos de gasto",
            description = "Obtiene todos los objetos de gasto registrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
            }
    )
    @GetMapping
    public List<ObjGastoEntity> obtenerObjGasto() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar objeto de gasto",
            description = "Busca un objeto de gasto por partida. Ejemplo: 41100",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Objeto encontrado"),
                    @ApiResponse(responseCode = "404", description = "Objeto no encontrado")
            }
    )
    @GetMapping("/{partida}")
    public ObjGastoEntity obtenerObjGasto(@PathVariable String partida) {
        return service.buscar(partida);
    }

    @Operation(
            summary = "Registrar objeto de gasto",
            description = "Agrega un nuevo objeto de gasto",
            requestBody = @RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ObjGastoEntity.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo",
                                    value = "{\"Partida\": \"41100\", \"Gestion\": 2024, \"Descrip\": \"Edificios\"}"
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Objeto registrado correctamente")
            }
    )
    @PostMapping
    public ObjGastoEntity agregarObjGasto(@org.springframework.web.bind.annotation.RequestBody ObjGastoEntity objGasto) {
        return service.guardar(objGasto);
    }

    @Operation(
            summary = "Actualizar objeto de gasto",
            description = "Actualiza un objeto de gasto existente. Ejemplo partida: 41100",
            requestBody = @RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ObjGastoEntity.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo",
                                    value = "{\"Partida\": \"41100\", \"Gestion\": 2025, \"Descrip\": \"Edificios Actualizados\"}"
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Objeto actualizado correctamente")
            }
    )
    @PutMapping("/{partida}")
    public ObjGastoEntity actualizarObjGasto(@PathVariable String partida,
                                              @org.springframework.web.bind.annotation.RequestBody ObjGastoEntity objGasto) {
        return service.actualizar(partida, objGasto);
    }

    @Operation(
            summary = "Eliminar objeto de gasto",
            description = "Elimina un objeto de gasto. Ejemplo partida: 41100",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Objeto eliminado correctamente")
            }
    )
    @DeleteMapping("/{partida}")
    public String eliminarObjGasto(@PathVariable String partida) {
        service.eliminar(partida);
        return "Objeto de gasto eliminado correctamente";
    }
}