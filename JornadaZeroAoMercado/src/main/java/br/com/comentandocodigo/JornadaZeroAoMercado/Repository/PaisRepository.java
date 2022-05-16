package br.com.comentandocodigo.JornadaZeroAoMercado.Repository;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer> {

    //salvar
    //editar
    //deletar
    //buscar -> id, todos
    List<Pais> findAll();
    List<Pais> findAllByNOME( String nomeChamada );
    Pais findByNOME( String nomeChamada );

}
