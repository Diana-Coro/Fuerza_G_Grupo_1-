package com.example.vSIAF.controller;

import com.example.vSIAF.model.UnidadAdmin;
import com.example.vSIAF.service.UnidadAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadadmin")
public class UnidadAdminController {

    private final UnidadAdminService service;

    public UnidadAdminController(UnidadAdminService service) {
        this.service = service;
    }

    // LISTAR
    @GetMapping
    public List<UnidadAdmin> listar() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{unidad}")
    public UnidadAdmin buscar(@PathVariable Long unidad) {
        return service.buscarPorUnidad(unidad);
    }

    // CREAR
    @PostMapping
    public UnidadAdmin crear(@RequestBody UnidadAdmin unidadAdmin) {
        return service.crear(unidadAdmin);
    }

    // ACTUALIZAR
    @PutMapping("/{unidad}")
    public UnidadAdmin actualizar(@PathVariable Long unidad,
                                  @RequestBody UnidadAdmin unidadAdmin) {
        return service.actualizar(unidad, unidadAdmin);
    }

    // ELIMINAR
    @DeleteMapping("/{unidad}")
    public String eliminar(@PathVariable Long unidad) {
        return service.eliminar(unidad);
    }
}