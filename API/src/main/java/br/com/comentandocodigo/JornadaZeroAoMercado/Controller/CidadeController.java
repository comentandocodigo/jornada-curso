package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Cidade;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.CidadeRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.CidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cidade")
public class CidadeController extends GenericController<CidadeService, CidadeRepository, Cidade, Integer> {
}
