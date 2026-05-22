package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.EstadoEntity;
import com.example.vSIAF.service.EstadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estado")
@Tag(name = "Estado API", description = "CRUD de la tabla Estado")
public class EstadoController {

    private final EstadoService service;

    public EstadoController(EstadoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar estados")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de estados",
            content = @Content(
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo 1",
                                    value = """
                                [
                                   {
                                      "codestado":1,
                                      "nomestado":"Bueno"
                                   },
                                   {
                                      "codestado":2,
                                      "nomestado":"Regular"
                                   }
                                ]
                                """
                            )
                    }
            )
    )
    @GetMapping
    public List<EstadoEntity> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar estado por ID")
    @GetMapping("/{id}")
    public Optional<EstadoEntity> buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(summary = "Insertar estado", description = "Solo inserte uno de estos valores: Bueno, Regular o Malo")
    @PostMapping
    public EstadoEntity guardar(@RequestBody EstadoEntity estado) {
        return service.guardar(estado);
    }

    @Operation(summary = "Actualizar estado")
    @PutMapping("/{id}")
    public EstadoEntity actualizar(@PathVariable Integer id, @RequestBody EstadoEntity nuevo) {

        EstadoEntity estado = service.buscar(id).orElse(null);

        if (estado != null) {

            estado.setNomestado(nuevo.getNomestado());

            return service.guardar(estado);
        }

        return null;
    }

    @Operation(summary = "Eliminar estado")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return "Estado eliminado";
    }
}