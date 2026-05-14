package com.example.vSIAF.Controller;

import com.example.vSIAF.model.UnidadAdmin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/unidadadmin")
public class UnidadAdminController {

    private final List<UnidadAdmin> unidades = new ArrayList<>();

    public UnidadAdminController() {
        unidades.add(new UnidadAdmin(1L, 1L, "Unidad administrativa", "Potosi"));
    }

    @GetMapping
    public List<UnidadAdmin> listar() {
        return unidades;
    }

    @GetMapping("/{unidad}")
    public UnidadAdmin buscar(@PathVariable Long unidad) {
        return unidades.stream()
                .filter(item -> item.getUnidad().equals(unidad))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public UnidadAdmin crear(@RequestBody UnidadAdmin unidadAdmin) {
        unidades.add(unidadAdmin);
        return unidadAdmin;
    }

    @PutMapping("/{unidad}")
    public UnidadAdmin actualizar(@PathVariable Long unidad,
                                  @RequestBody UnidadAdmin unidadAdmin) {
        for (UnidadAdmin item : unidades) {
            if (item.getUnidad().equals(unidad)) {
                item.setEntidad(unidadAdmin.getEntidad());
                item.setUnidad(unidadAdmin.getUnidad());
                item.setDescrip(unidadAdmin.getDescrip());
                item.setCiudad(unidadAdmin.getCiudad());
                return item;
            }
        }
        return null;
    }

    @DeleteMapping("/{unidad}")
    public String eliminar(@PathVariable Long unidad) {
        unidades.removeIf(item -> item.getUnidad().equals(unidad));
        return "UnidadAdmin eliminada correctamente";
    }
}