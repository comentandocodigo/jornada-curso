package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.PaisRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.PaisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//localhost:8080 + (restante)
//localhost:8080/api/pais
@Controller
@RequestMapping( "/api/pais" )
public class PaisController extends GenericController<PaisService, PaisRepository, Pais, Integer> {

    /*@Autowired
    private PaisService service;

    //localhost:8080/api/pais/all
    @GetMapping("/all")
    @ResponseBody
    public List<Pais> findAllExposedApi() {
        return service.allEntity();
    }

    @PostMapping("/new")
    @ResponseBody
    public Pais createExposedApi(@RequestBody Pais pais) {
        return service.createEntity(pais);
    }

    //localhost:8080/api/pais/edit/4
    @PutMapping("/edit/{id}")
    @ResponseBody
    public Pais editExposedApi(@RequestBody Pais pais, @PathVariable Integer id) {
        return service.updateEntity(pais, id);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Pais findOneExposedApi( @PathVariable Integer id ) {
        return service.findEntityById(id);
    }*/

}
