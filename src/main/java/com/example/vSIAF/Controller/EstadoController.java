package com.example.vSIAF.Controller;

import com.example.vSIAF.Estado;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    List<Estado> lista = new ArrayList<>();


    public EstadoController() {

        lista.add(new Estado(1, "Bueno"));
        lista.add(new Estado(2, "Regular"));
        lista.add(new Estado(3, "Malo"));
    }

    @GetMapping
    public List<Estado> listar() {
        return lista;
    }


    @GetMapping("/{id}")
    public Estado buscar(@PathVariable Integer id) {

        for (Estado e : lista) {
            if (e.getCodestado().equals(id)) {
                return e;
            }
        }

        return null;
    }


    @PostMapping
    public Estado insertar(@RequestBody Estado estado) {

        lista.add(estado);

        return estado;
    }


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


    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        lista.removeIf(e -> e.getCodestado().equals(id));

        return "Eliminado";
    }
}