package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends PessoaRepository<Usuario>, CrudRepository<Usuario, Integer> {
}
