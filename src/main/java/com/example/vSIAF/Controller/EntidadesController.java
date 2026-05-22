package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.EntidadesEntity;
import com.example.vSIAF.service.EntidadesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidades")
@Tag(name = "Entidades API", description = "CRUD de la tabla Entidades")
public class EntidadesController {


        private final EntidadesService service;

        public EntidadesController(EntidadesService service) {
            this.service = service;
        }

        @Operation(summary = "Listar Entidades",
                description = "Obtiene todas las entidades registradas")
        @GetMapping
        public List<EntidadesEntity> obtenerEntidades() {
            return service.listar();
        }

        @Operation(summary = "Obtener Entidades por id(entidad)",
                description = "Busca una institución usando su identificador 'entidad'")
        @GetMapping("/{id}")
        public EntidadesEntity obtenerEntidad(@PathVariable Integer id) {
            return service.buscar(id);
        }

        @Operation(summary = "Registrar nuevas Entidades",
                description = "Agrega una nueva institución al sistema")
        @PostMapping
        public EntidadesEntity agregarEntidad(@RequestBody EntidadesEntity entidad) {
            return service.guardar(entidad);
        }

        @Operation(summary = "Actualizar Entidades por id(entidad)",
                description = "Modifica los campos de una entidad localizándola por su ID")
        @PutMapping("/{id}")
        public EntidadesEntity actualizarEntidad(@PathVariable Integer id, @RequestBody EntidadesEntity entidad) {
            return service.actualizar(id, entidad);
        }

        @Operation(summary = "Eliminar Entidades por id(entidad)",
                description = "Borra un registro de forma permanente")
        @DeleteMapping("/{id}")
        public String eliminarEntidad(@PathVariable Integer id) {
            service.eliminar(id);
            return "Entidad eliminada correctamente";
        }
    }



