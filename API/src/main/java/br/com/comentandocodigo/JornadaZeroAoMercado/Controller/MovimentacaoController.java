package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Movimentacao;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.MovimentacaoRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.MovimentacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/movimentacao")
public class MovimentacaoController extends GenericController<MovimentacaoService, MovimentacaoRepository, Movimentacao, Integer> {
}
