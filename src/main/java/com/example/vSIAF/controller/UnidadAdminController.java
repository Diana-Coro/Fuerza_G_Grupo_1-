package com.example.vSIAF.controller;

import com.example.vSIAF.model.UnidadAdmin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnidadAdminController {

    @GetMapping("/unidadadmin")
    public UnidadAdmin unidadAdmin() {
        return new UnidadAdmin(1L, 1L, "Unidad administrativa", "Potosi");
    }
}