package com.example.vSIAF.controllers;

import com.example.vSIAF.dtos.EntidadesDTO;
import com.example.vSIAF.services.EntidadesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntidadesControllers {
    private final EntidadesService entidadService;

    public EntidadesControllers(EntidadesService entidadService){
        this.entidadService = entidadService;
    }


    @GetMapping("/entideades")
    public List<EntidadesDTO> getEntidades() {
        return entidadService.obtenerEntidades();
    }



    @GetMapping("/entidades/{entidad}")
    public EntidadesDTO getEntidadesByEntidad(@PathVariable long entidad){
        return entidadService.obtenerEntidad(entidad);
    }



    @PostMapping("/entidades")
    public EntidadesDTO postEntidades(@RequestBody EntidadesDTO nuevo){
        return entidadService.crearEntidades(nuevo);
    }


    @PutMapping("/entidades/{entidad}")
    public EntidadesDTO putEntidades(@PathVariable long entidad, @RequestBody EntidadesDTO editado){
        return entidadService.editarEntidades(entidad, editado);
    }



    @DeleteMapping("entidades/{entidad}")
    public EntidadesDTO deleteEntidades(@PathVariable long entidad){
        return entidadService.eliminarEntidad(entidad);
    }




}
