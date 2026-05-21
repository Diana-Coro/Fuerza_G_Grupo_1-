package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.CtaParEntity;
import com.example.vSIAF.service.CtaParService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ctapar")

@Tag(name = "CtaPar API", description = "CRUD de la tabla Cuenta Partida") 
public class CtaParController {

    private final CtaParService service;

    public CtaParController(CtaParService service) {
        this.service = service;
    }

    @Operation(summary = "Lista de cuentas partida")
    @GetMapping
    public List<CtaParEntity> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar cuenta partida por ID")
    @GetMapping("/{id}")
    public CtaParEntity buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(summary = "Registrar cuenta partida")
    @PostMapping
    public CtaParEntity insertar(@RequestBody CtaParEntity ctapar) {
        return service.guardar(ctapar);
    }

    @Operation(summary = "Actualizar cuenta partida")
    @PutMapping("/{id}")
    public CtaParEntity actualizar(@PathVariable Integer id, @RequestBody CtaParEntity nuevo) {
        return service.actualizar(id, nuevo);
    }

    @Operation(summary = "Eliminar cuenta partida")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "Eliminado";
    }
}