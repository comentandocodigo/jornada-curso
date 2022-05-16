package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Banco;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.BancoRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.BancoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/banco")
public class BancoController extends GenericController<BancoService, BancoRepository, Banco, Integer> {
}
