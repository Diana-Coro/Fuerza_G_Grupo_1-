package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.EntidadEntity;
import com.example.vSIAF.service.EntidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidad") // URL base simplificada
@Tag(name = "Entidad API", description = "CRUD de la tabla Entidad")
public class EntidadController {

    private final EntidadService service;

    // Inyección por constructor limpia, sin @Autowired
    public EntidadController(EntidadService service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista de entidades",
            description = "Obtiene todas las entidades registradas"
    )
    @GetMapping
    public List<EntidadEntity> obtenerEntidades() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar entidad",
            description = "Busca una entidad por ID"
    )
    @GetMapping("/{id}")
    public EntidadEntity obtenerEntidad(@PathVariable long id) {
        return service.buscar(id);
    }

    @Operation(
            summary = "Registrar entidad",
            description = "Agrega una nueva entidad"
    )
    @PostMapping
    public EntidadEntity agregarEntidad(@RequestBody EntidadEntity entidad) {
        return service.guardar(entidad);
    }

    @Operation(
            summary = "Actualizar entidad",
            description = "Actualiza una entidad existente"
    )
    @PutMapping("/{id}")
    public EntidadEntity actualizarEntidad(@PathVariable long id,
                                           @RequestBody EntidadEntity entidad) {
        return service.actualizar(id, entidad);
    }

    @Operation(
            summary = "Eliminar entidad",
            description = "Elimina una entidad"
    )
    @DeleteMapping("/{id}")
    public String eliminarEntidad(@PathVariable long id) {
        service.eliminar(id);
        return "Entidad eliminada correctamente"; // Retorno de texto plano idéntico a Mes
    }
}
