package com.example.vSIAF.Controller;
 
import com.example.vSIAF.model.ObjGasto;
import org.springframework.web.bind.annotation.*;
 
import java.util.ArrayList;
import java.util.List;
 
@RestController
@RequestMapping("/api/objgasto")
public class ObjGastoController
{
    
    private List<ObjGasto> listaObjGasto = new ArrayList<>();
 
    public ObjGastoController() {
        
        listaObjGasto.add(new ObjGasto(0, "41100", "Edificios"));
    }
    @GetMapping
    public List<ObjGasto> obtenerObjGasto() {
        return listaObjGasto;
    }
 
    @GetMapping("/{posicion}")
    public ObjGasto obtenerObjGastoPorPosicion(@PathVariable int posicion) {
        return listaObjGasto.get(posicion);
    }
 
    @PostMapping
    public String agregarObjGasto(@RequestBody ObjGasto objGasto) {
        listaObjGasto.add(objGasto);
        return "Objeto de gasto agregado correctamente";
    }
 
    @PutMapping("/{posicion}")
    public String actualizarObjGasto(@PathVariable int posicion, @RequestBody ObjGasto objGastoActualizado) {
        listaObjGasto.set(posicion, objGastoActualizado);
        return "Objeto de gasto actualizado correctamente";
    }
 
    @DeleteMapping("/{posicion}")
    public String eliminarObjGasto(@PathVariable int posicion) {
        listaObjGasto.remove(posicion);
        return "Objeto de gasto eliminado correctamente";
    }

}