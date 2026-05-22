package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.BajaEntity;
import com.example.vSIAF.service.BajaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baja")
@Tag(name = "Baja API ", description = "CRUD de la tabla Baja")
public class BajaController {

    private final BajaService service;

    public BajaController(BajaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar Baja",
            description = "Obtiene todos los registros de baja")
    @GetMapping
    public List<BajaEntity> obtenerBajas() {
        return service.listar();
    }

    @Operation(summary = "Obtener Baja por id",
            description = "Busca una baja específica utilizando su código 'codbaja'")
    @GetMapping("/{id}")
    public BajaEntity obtenerBaja(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(summary = "Registrar nueva Baja",
            description = "Agrega un nuevo regidtro de baja al sistema")
    @PostMapping
    public BajaEntity agregarBaja(@RequestBody BajaEntity baja) {
        return service.guardar(baja);
    }

    @Operation(
            summary = "Actualizar Baja por id",
            description = "Busca el registro mediante el id(codbaja)"
    )
    @PutMapping("/{id}")
    public BajaEntity actualizarBaja(@PathVariable Integer id, @RequestBody BajaEntity baja) {
        return service.actualizar(id, baja);
    }

    @Operation(summary = "Eliminar Baja por id",
            description = "Borra un registro de baja de forma permanente")
    @DeleteMapping("/{id}")
    public String eliminarBaja(@PathVariable Integer id) {
        service.eliminar(id);
        return "Baja eliminada correctamente";
    }
}
