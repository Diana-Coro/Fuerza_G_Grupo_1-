package com.example.vSIAF.Controller;

import com.example.vSIAF.entity.ObjGastoEntity;
import com.example.vSIAF.service.ObjGastoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objgasto")
@CrossOrigin(origins = "*")
@Tag(name = "ObjGasto API", description = "CRUD de la tabla ObjGasto")
public class ObjGastoController {

    private final ObjGastoService service;

    public ObjGastoController(ObjGastoService service) {
        this.service = service;
    }

    @Operation(
            summary = "Lista de objetos de gasto",
            description = "Obtiene todos los objetos de gasto registrados"
    )
    @GetMapping
    public List<ObjGastoEntity> obtenerObjGasto() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar objeto de gasto",
            description = "Busca un objeto de gasto por partida"
    )
    @GetMapping("/{partida}")
    public ObjGastoEntity obtenerObjGasto(@PathVariable String partida) {
        return service.buscar(partida);
    }

    @Operation(
            summary = "Registrar objeto de gasto",
            description = "Agrega un nuevo objeto de gasto"
    )
    @PostMapping
    public ObjGastoEntity agregarObjGasto(@RequestBody ObjGastoEntity objGasto) {
        return service.guardar(objGasto);
    }

    @Operation(
            summary = "Actualizar objeto de gasto",
            description = "Actualiza un objeto de gasto existente"
    )
    @PutMapping("/{partida}")
    public ObjGastoEntity actualizarObjGasto(@PathVariable String partida,
                                              @RequestBody ObjGastoEntity objGasto) {
        return service.actualizar(partida, objGasto);
    }

    @Operation(
            summary = "Eliminar objeto de gasto",
            description = "Elimina un objeto de gasto"
    )
    @DeleteMapping("/{partida}")
    public String eliminarObjGasto(@PathVariable String partida) {
        service.eliminar(partida);
        return "Objeto de gasto eliminado correctamente";
    }
}