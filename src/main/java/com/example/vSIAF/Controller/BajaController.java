package com.example.vSIAF.Controller;

import com.example.vSIAF.model.Baja;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/baja")
public class BajaController {

    private List<Baja> listaBajas = new ArrayList<>();

    public BajaController() {
        listaBajas.add(new Baja(1, "Fin de contrato", "2025-01-10"));
        listaBajas.add(new Baja(2, "Renuncia", "2025-02-15"));
    }

    @GetMapping
    public ResponseEntity<List<Baja>> listar() {
        return ResponseEntity.ok(listaBajas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Baja> buscar(@PathVariable Integer id) {
        return listaBajas.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> insertar(@RequestBody Baja baja) {

        boolean existe = listaBajas.stream()
                .anyMatch(b -> b.getId().equals(baja.getId()));

        if (existe) {
            return ResponseEntity.badRequest().body("El ID ya existe");
        }

        listaBajas.add(baja);
        return ResponseEntity.status(201).body(baja);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {

        boolean eliminado = listaBajas.removeIf(b -> b.getId().equals(id));

        if (eliminado) {
            return ResponseEntity.ok("Eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}