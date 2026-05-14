package com.example.vSIAF.Controller;

import com.example.vSIAF.model.Mes;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/mes")
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

    @GetMapping
    public List<Mes> listar() {
        return listaMeses;
    }
}