package com.example.vSIAF.Controller;

import com.example.vSIAF.model.ObjGasto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/objgasto")
@Tag(name = "ObjGasto API", description = "CRUD de la tabla Objeto Gasto")
public class ObjGastoController {

    private List<ObjGasto> listaObjGasto = new ArrayList<>();

    public ObjGastoController() {

        listaObjGasto.add(new ObjGasto(0, "41100", "Edificios"));
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
            description = "Obtiene un objeto de gasto mediante su posición"
    )
    @GetMapping("/{posicion}")
    public ObjGasto obtenerObjGastoPorPosicion(@PathVariable int posicion) {
        return listaObjGasto.get(posicion);
    }

    @Operation(
            summary = "Registrar objeto de gasto",
            description = "Agrega un nuevo objeto de gasto al sistema"
    )
    @PostMapping
    public String agregarObjGasto(@RequestBody ObjGasto objGasto) {

        listaObjGasto.add(objGasto);

        return "Objeto de gasto agregado correctamente";
    }

    @Operation(
            summary = "Actualizar objeto de gasto",
            description = "Modifica un objeto de gasto existente"
    )
    @PutMapping("/{posicion}")
    public String actualizarObjGasto(@PathVariable int posicion,
                                     @RequestBody ObjGasto objGastoActualizado) {

        listaObjGasto.set(posicion, objGastoActualizado);

        return "Objeto de gasto actualizado correctamente";
    }

    @Operation(
            summary = "Eliminar objeto de gasto",
            description = "Elimina un objeto de gasto de la lista"
    )
    @DeleteMapping("/{posicion}")
    public String eliminarObjGasto(@PathVariable int posicion) {

        listaObjGasto.remove(posicion);

        return "Objeto de gasto eliminado correctamente";
    }
}