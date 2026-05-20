package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.BajaEntity;
import com.example.vSIAF.service.BajaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baja")
@Tag(name = "Baja API", description = "CRUD de la tabla Baja")
public class BajaController {

    private final BajaService service;

    public BajaController(BajaService service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista de bajas",
            description = "Obtiene todas las bajas registradas"
    )
    @GetMapping
    public List<BajaEntity> obtenerBajas() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar baja",
            description = "Busca una baja por ID"
    )
    @GetMapping("/{id}")
    public BajaEntity obtenerBaja(@PathVariable Long id) {
        return service.buscar(id);
    }

    @Operation(
            summary = "Registrar baja",
            description = "Agrega una nueva baja"
    )
    @PostMapping
    public BajaEntity agregarBaja(@RequestBody BajaEntity baja) {
        return service.guardar(baja);
    }

    @Operation(
            summary = "Actualizar baja",
            description = "Actualiza una baja existente"
    )
    @PutMapping("/{id}")
    public BajaEntity actualizarBaja(@PathVariable Long id,
                                     @RequestBody BajaEntity baja) {
        return service.actualizar(id, baja);
    }

    @Operation(
            summary = "Eliminar baja",
            description = "Elimina una baja"
    )
    @DeleteMapping("/{id}")
    public String eliminarBaja(@PathVariable Long id) {

        service.eliminar(id);

        return "Baja de registro eliminada correctamente";
    }
}
