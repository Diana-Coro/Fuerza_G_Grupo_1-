package com.example.vSIAF.Controller;

import com.example.vSIAF.model.Mes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/mes")
@Tag(name = "Mes API", description = "CRUD de la tabla Mes")
public class MesController {

    private List<Mes> listaMeses = new ArrayList<>();

    public MesController() {

        listaMeses.add(new Mes(1, "Enero"));
        listaMeses.add(new Mes(2, "Febrero"));
        listaMeses.add(new Mes(3, "Marzo"));
        listaMeses.add(new Mes(4, "Abril"));
        listaMeses.add(new Mes(5, "Mayo"));
        listaMeses.add(new Mes(6, "Junio"));
        listaMeses.add(new Mes(7, "Julio"));
        listaMeses.add(new Mes(8, "Agosto"));
        listaMeses.add(new Mes(9, "Septiembre"));
        listaMeses.add(new Mes(10, "Octubre"));
        listaMeses.add(new Mes(11, "Noviembre"));
        listaMeses.add(new Mes(12, "Diciembre"));

    }

    @Operation(
            summary = "Lista de meses",
            description = "Obtiene todos los meses registrados"
    )
    @GetMapping
    public List<Mes> obtenerMeses() {
        return listaMeses;
    }

    @Operation(
            summary = "Buscar mes por posición",
            description = "Obtiene un mes según su posición en la lista"
    )
    @GetMapping("/{posicion}")
    public Mes obtenerMesPorPosicion(@PathVariable int posicion) {
        return listaMeses.get(posicion);
    }

    @Operation(
            summary = "Registrar mes",
            description = "Agrega un nuevo mes al sistema"
    )
    @PostMapping
    public String agregarMes(@RequestBody Mes mes) {
        listaMeses.add(mes);
        return "Mes agregado correctamente";
    }

    @Operation(
            summary = "Actualizar mes",
            description = "Actualiza un mes existente"
    )
    @PutMapping("/{posicion}")
    public String actualizarMes(@PathVariable int posicion, @RequestBody Mes mesActualizado) {
        listaMeses.set(posicion, mesActualizado);
        return "Mes actualizado correctamente";
    }

    @Operation(
            summary = "Eliminar mes",
            description = "Elimina un mes de la lista"
    )
    @DeleteMapping("/{posicion}")
    public String eliminarMes(@PathVariable int posicion) {
        listaMeses.remove(posicion);
        return "Mes eliminado correctamente";
    }
}