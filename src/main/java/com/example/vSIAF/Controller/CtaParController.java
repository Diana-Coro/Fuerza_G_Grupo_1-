package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.CtaParEntity;
import com.example.vSIAF.service.CtaParService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cta_par")
@Tag(name = "Cta_par API", description = "CRUD de la tabla Cuenta Partida") 
public class CtaParController {

    private final CtaParService service;

    public CtaParController(CtaParService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de cuentas partida")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de cuentas partida obtenidas con éxito",
            content = @Content(
                    examples = {
                            @ExampleObject(
                                    name = "Ejemplo 1",
                                    value = """
                                [
                                   {
                                      "Codcont": 1,
                                      "Partida": 11700,
                                      "Gestion": 2026
                                   },
                                   {
                                      "Codcont": 2,
                                      "Partida": 22100,
                                      "Gestion": 2026
                                   }
                                ]
                                """
                            )
                    }
            )
    )
    @GetMapping
    public List<CtaParEntity> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar cuenta partida por Codcont")
    @GetMapping("/{Codcont}")
    public Optional<CtaParEntity> buscar(@PathVariable("Codcont") Integer codcont) {
        // Retorna Optional para mantener consistencia con EstadoController
        return service.buscar(codcont);
    }

    @Operation(summary = "Registrar cuenta partida")
    @PostMapping
    public CtaParEntity guardar(@RequestBody CtaParEntity ctapar) {
        // Nombre del método cambiado a 'guardar' para unificar nomenclatura
        return service.guardar(ctapar);
    }

    @Operation(summary = "Actualizar cuenta partida")
    @PutMapping("/{Codcont}")
    public CtaParEntity actualizar(@PathVariable("Codcont") Integer codcont, @RequestBody CtaParEntity nuevo) {
        return service.actualizar(codcont, nuevo);
    }

    @Operation(summary = "Eliminar cuenta partida")
    @DeleteMapping("/{Codcont}")
    public String eliminar(@PathVariable("Codcont") Integer codcont) {
        service.eliminar(codcont);
        return "Cuenta partida eliminada";
    }
}