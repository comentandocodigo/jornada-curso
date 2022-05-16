package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Bairro;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.BairroRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.BairroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/bairro")
public class BairroController extends GenericController<BairroService, BairroRepository, Bairro, Integer> {
}
