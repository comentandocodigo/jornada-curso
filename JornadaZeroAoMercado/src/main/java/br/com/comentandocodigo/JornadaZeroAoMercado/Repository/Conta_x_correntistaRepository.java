package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Conta_x_correntista;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Conta_x_correntistaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Conta_x_correntistaRepository extends CrudRepository<Conta_x_correntista, Conta_x_correntistaId> {
}
