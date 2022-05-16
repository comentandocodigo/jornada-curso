package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Agencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenciaRepository extends CrudRepository<Agencia, Integer> {
    Agencia findByNOME( String nome );
    List<Agencia> findAll();
}
