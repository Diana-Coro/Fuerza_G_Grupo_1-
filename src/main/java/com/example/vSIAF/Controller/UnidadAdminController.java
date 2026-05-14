package com.example.vSIAF.Controller;

import com.example.vSIAF.model.UnidadAdmin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/unidadadmin")
public class UnidadAdminController {

    private List<UnidadAdmin> listaUnidadAdmin = new ArrayList<>();

    public UnidadAdminController() {

        listaUnidadAdmin.add(
                new UnidadAdmin(1L, 1L, "Unidad administrativa", "Potosi")
        );
    }

    @GetMapping
    public List<UnidadAdmin> obtenerUnidadAdmin() {
        return listaUnidadAdmin;
    }

    @GetMapping("/{posicion}")
    public UnidadAdmin obtenerUnidadAdminPorPosicion(@PathVariable int posicion) {
        return listaUnidadAdmin.get(posicion);
    }

    @PostMapping
    public String agregarUnidadAdmin(@RequestBody UnidadAdmin unidadAdmin) {

        listaUnidadAdmin.add(unidadAdmin);

        return "Unidad administrativa agregada correctamente";
    }

    @PutMapping("/{posicion}")
    public String actualizarUnidadAdmin(
            @PathVariable int posicion,
            @RequestBody UnidadAdmin unidadAdminActualizada
    ) {

        listaUnidadAdmin.set(posicion, unidadAdminActualizada);

        return "Unidad administrativa actualizada correctamente";
    }

    @DeleteMapping("/{posicion}")
    public String eliminarUnidadAdmin(@PathVariable int posicion) {

        listaUnidadAdmin.remove(posicion);

        return "Unidad administrativa eliminada correctamente";
    }
}