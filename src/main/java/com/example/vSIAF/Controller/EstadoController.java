package com.example.vSIAF.Controller;

import com.example.vSIAF.model.Estado;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api/estado")
public class EstadoController {

    List<Estado> lista = new ArrayList<>();

    // DATOS INICIALES
    public EstadoController() {

        lista.add(new Estado(1, "Bueno"));
        lista.add(new Estado(2, "Regular"));
        lista.add(new Estado(3, "Malo"));
    }
    @Operation(
            summary = "Lista de estados",
            description = "Todos los estados registrados"
    )
    @GetMapping
    public List<Estado> listar() {
        return lista;
    }
    @Operation(
            summary = "Buscar estado por ID",
            description = "Estado específico mediante un entero del 1 al 3 código"
    )
    @GetMapping("/{id}")
    public Estado buscar(@PathVariable Integer id) {

        for (Estado e : lista) {
            if (e.getCodestado().equals(id)) {
                return e;
            }
        }

        return null;
    }
    @Operation(
            summary = "Insertar estado",
            description = "Guarda un nuevo estado en la lista"
    )
    @PostMapping
    public Estado insertar(@RequestBody Estado estado) {

        lista.add(estado);

        return estado;
    }

    @Operation(
            summary = "Actualizar estado",
            description = "Modifica el estado mediante su ID"
    )
    @PutMapping("/{id}")
    public Estado actualizar(@PathVariable Integer id,
                             @RequestBody Estado nuevo) {

        for (Estado e : lista) {

            if (e.getCodestado().equals(id)) {

                e.setNomestado(nuevo.getNomestado());

                return e;
            }
        }

        return null;
    }

    @Operation(
            summary = "Eliminar estado",
            description = "Elimina el estado mediante su ID"
    )
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        lista.removeIf(e -> e.getCodestado().equals(id));
        return "Eliminado";
    }
}
