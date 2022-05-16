package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Correntista;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.CorrentistaRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.CorrentistaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/correntista")
public class CorrentistaController extends GenericController<CorrentistaService, CorrentistaRepository, Correntista, Integer> {
}
