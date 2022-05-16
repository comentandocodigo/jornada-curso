package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Agencia;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.AgenciaRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.AgenciaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/agencia")
public class AgenciaController extends GenericController<AgenciaService, AgenciaRepository, Agencia, Integer> {
}
