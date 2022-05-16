package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Usuario;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericService<UsuarioRepository, Usuario, Integer> {
}
