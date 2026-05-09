package Controller;

import com.example.Cta_par.model.CtaPar;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ctapar")
public class CtaParController {

    List<CtaPar> lista = new ArrayList<>();

    public CtaParController() {

        lista.add(new CtaPar(1, 41100, 0));
        lista.add(new CtaPar(2, 43100, 0));
        lista.add(new CtaPar(3, 43200, 0));
        lista.add(new CtaPar(7, 43300, 0));
        lista.add(new CtaPar(8, 43300, 0));
    }

    @GetMapping
    public List<CtaPar> listar() {
        return lista;
    }

    @GetMapping("/{id}")
    public CtaPar buscar(@PathVariable Integer id) {

        for (CtaPar c : lista) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    @PostMapping
    public CtaPar insertar(@RequestBody CtaPar ctapar) {

        lista.add(ctapar);

        return ctapar;
    }

    @PutMapping("/{id}")
    public CtaPar actualizar(@PathVariable Integer id,
                             @RequestBody CtaPar nuevo) {

        for (CtaPar c : lista) {

            if (c.getId().equals(id)) {

                c.setCodcont(nuevo.getCodcont());
                c.setGestion(nuevo.getGestion());

                return c;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        lista.removeIf(c -> c.getId().equals(id));

        return "Eliminado";
    }
}