package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository<T extends Pessoa> extends CrudRepository<T, Integer> {
}
