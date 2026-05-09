package com.example.vSIAF.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnidadAdminController {

    @GetMapping("/unidadadmin")
    public String unidadAdmin() {
        return "Tabla UnidadAdmin funcionando";
    }
}