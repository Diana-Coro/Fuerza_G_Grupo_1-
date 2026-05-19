package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.MesEntity;
import com.example.vSIAF.service.MesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mes")
@Tag(name = "Mes API", description = "CRUD de la tabla Mes")
public class MesController {

    private final MesService service;

    public MesController(MesService service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista de meses",
            description = "Obtiene todos los meses registrados"
    )
    @GetMapping
    public List<MesEntity> obtenerMeses() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar mes",
            description = "Busca un mes por ID"
    )
    @GetMapping("/{id}")
    public MesEntity obtenerMes(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(
            summary = "Registrar mes",
            description = "Agrega un nuevo mes"
    )
    @PostMapping
    public MesEntity agregarMes(@RequestBody MesEntity mes) {
        return service.guardar(mes);
    }

    @Operation(
            summary = "Actualizar mes",
            description = "Actualiza un mes existente"
    )
    @PutMapping("/{id}")
    public MesEntity actualizarMes(@PathVariable Integer id,
                                   @RequestBody MesEntity mes) {
        return service.actualizar(id, mes);
    }

    @Operation(
            summary = "Eliminar mes",
            description = "Elimina un mes"
    )
    @DeleteMapping("/{id}")
    public String eliminarMes(@PathVariable Integer id) {

        service.eliminar(id);

        return "Mes eliminado correctamente";
    }
}