package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Endereco;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.EnderecoRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/endereco")
public class EnderecoController extends GenericController<EnderecoService, EnderecoRepository, Endereco, Integer> {
}
