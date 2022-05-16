package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Conta;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.ContaRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.ContaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/conta")
public class ContaController extends GenericController<ContaService, ContaRepository, Conta, Integer> {
}
