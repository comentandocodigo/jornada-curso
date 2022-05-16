package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Gerente;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.GerenteRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.GerenteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/gerente")
public class GerenteController extends GenericController<GerenteService, GerenteRepository, Gerente, Integer> {
}
