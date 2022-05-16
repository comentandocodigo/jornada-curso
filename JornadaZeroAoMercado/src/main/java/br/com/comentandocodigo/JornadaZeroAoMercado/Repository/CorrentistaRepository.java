package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Correntista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorrentistaRepository extends CrudRepository<Correntista, Integer> {
    Correntista findByNOME( String nome );
    List<Correntista> findAll();
}
