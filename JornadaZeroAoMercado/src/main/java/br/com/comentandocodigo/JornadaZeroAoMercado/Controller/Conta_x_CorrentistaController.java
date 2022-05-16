package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Conta_x_correntista;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Conta_x_correntistaId;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.Conta_x_correntistaRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.Conta_x_CorrentistaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/conta/correntista")
public class Conta_x_CorrentistaController extends GenericController<Conta_x_CorrentistaService, Conta_x_correntistaRepository, Conta_x_correntista, Conta_x_correntistaId> {
}
