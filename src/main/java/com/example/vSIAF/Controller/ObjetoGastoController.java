package com.example.vSIAF.controller;

import com.example.vSIAF.entity.ObjetoGasto;
import com.example.vSIAF.service.ObjetoGastoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/objeto-gasto")
@CrossOrigin("*")
public class ObjetoGastoController {

    private final ObjetoGastoService service;

    public ObjetoGastoController(ObjetoGastoService service) {
        this.service = service;
    }

    // GET - listar todos
    @GetMapping
    public List<ObjetoGasto> listarTodos() {
        return service.listarTodos();
    }

    // GET por ID
    @GetMapping("/{id}")
    public Optional<ObjetoGasto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // POST - guardar
    @PostMapping
    public ObjetoGasto guardar(@RequestBody ObjetoGasto objetoGasto) {
        return service.guardar(objetoGasto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}