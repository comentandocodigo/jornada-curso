package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Bairro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BairroRepository extends CrudRepository<Bairro, Integer> {
    Bairro findByNOME( String nome );
    List<Bairro> findAll();
}
