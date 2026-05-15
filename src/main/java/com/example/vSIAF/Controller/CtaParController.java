package com.example.vSIAF.Controller;

import com.example.vSIAF.model.CtaPar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ctapar")
@Tag(name = "CtaPar API", description = "CRUD de la tabla Cuenta Partida")
public class CtaParController {

    List<CtaPar> lista = new ArrayList<>();

    public CtaParController() {

        lista.add(new CtaPar(1, 41100, 0));
        lista.add(new CtaPar(2, 43100, 0));
        lista.add(new CtaPar(3, 43200, 0));
        lista.add(new CtaPar(7, 43300, 0));
        lista.add(new CtaPar(8, 43300, 0));
    }

    @Operation(
            summary = "Lista de cuentas partida",
            description = "Obtiene todas las cuentas partida registradas"
    )
    @GetMapping
    public List<CtaPar> listar() {

        return lista;
    }

    @Operation(
            summary = "Buscar cuenta partida",
            description = "Obtiene una cuenta partida mediante su ID"
    )
    @GetMapping("/{id}")
    public CtaPar buscar(@PathVariable Integer id) {

        for (CtaPar c : lista) {

            if (c.getId().equals(id)) {

                return c;
            }
        }

        return null;
    }

    @Operation(
            summary = "Registrar cuenta partida",
            description = "Agrega una nueva cuenta partida"
    )
    @PostMapping
    public CtaPar insertar(@RequestBody CtaPar ctapar) {

        lista.add(ctapar);

        return ctapar;
    }

    @Operation(
            summary = "Actualizar cuenta partida",
            description = "Modifica una cuenta partida existente"
    )
    @PutMapping("/{id}")
    public CtaPar actualizar(@PathVariable Integer id,
                             @RequestBody CtaPar nuevo) {

        for (CtaPar c : lista) {

            if (c.getId().equals(id)) {

                c.setCodcont(nuevo.getCodcont());
                c.setGestion(nuevo.getGestion());

                return c;
            }
        }

        return null;
    }

    @Operation(
            summary = "Eliminar cuenta partida",
            description = "Elimina una cuenta partida mediante su ID"
    )
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        lista.removeIf(c -> c.getId().equals(id));

        return "Eliminado";
    }
}