package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Estado;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.EstadoRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.EstadoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/estado")
public class EstadoController extends GenericController<EstadoService, EstadoRepository, Estado, Integer> {
}