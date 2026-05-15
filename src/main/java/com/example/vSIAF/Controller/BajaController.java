package com.example.vSIAF.Controller;

import com.example.vSIAF.model.Baja;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/baja")
@Tag(name = "Baja API", description = "CRUD de la tabla Baja")
public class BajaController {

    private List<Baja> listaBajas = new ArrayList<>();

    public BajaController() {

        listaBajas.add(new Baja(1, "Fin de contrato", "2025-01-10"));
        listaBajas.add(new Baja(2, "Renuncia", "2025-02-15"));
    }

    @Operation(
            summary = "Lista de bajas",
            description = "Obtiene todas las bajas registradas"
    )
    @GetMapping
    public ResponseEntity<List<Baja>> listar() {

        return ResponseEntity.ok(listaBajas);
    }

    @Operation(
            summary = "Buscar baja por ID",
            description = "Obtiene una baja específica mediante su ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Baja> buscar(@PathVariable Integer id) {

        return listaBajas.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Registrar baja",
            description = "Agrega una nueva baja al sistema"
    )
    @PostMapping
    public ResponseEntity<?> insertar(@RequestBody Baja baja) {

        boolean existe = listaBajas.stream()
                .anyMatch(b -> b.getId().equals(baja.getId()));

        if (existe) {

            return ResponseEntity
                    .badRequest()
                    .body("El ID ya existe");
        }

        listaBajas.add(baja);

        return ResponseEntity.status(201).body(baja);
    }

    @Operation(
            summary = "Actualizar baja",
            description = "Modifica una baja existente mediante su ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id,
                                        @RequestBody Baja nueva) {

        for (Baja b : listaBajas) {

            if (b.getId().equals(id)) {

                b.setMotivo(nueva.getMotivo());
                b.setFecha(nueva.getFecha());

                return ResponseEntity.ok(b);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(
            summary = "Eliminar baja",
            description = "Elimina una baja mediante su ID"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {

        boolean eliminado =
                listaBajas.removeIf(b -> b.getId().equals(id));

        if (eliminado) {

            return ResponseEntity.ok("Eliminado correctamente");

        } else {

            return ResponseEntity.notFound().build();
        }
    }
}