package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Usuario;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.UsuarioRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController extends GenericController<UsuarioService, UsuarioRepository, Usuario, Integer> {
}
