package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer> {
    Estado findByNOME( String nome );
    List<Estado> findAll();
}
