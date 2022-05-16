package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Estado;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.EstadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class EstadoTests {

    @Autowired
    EstadoRepository repository;

    Pais pais = new Pais();
    Estado estado = new Estado();
    Estado estadoBanco;

    @BeforeEach
    void init() {
        pais.setNOME("Brasil");

        estado.setNOME("Roraima");
        estado.setPais(pais);

        estadoBanco = repository.save(estado);
    }

    @Test
    public void adicionarUmEstadoNoBanco() {
        Estado estadoNovo = new Estado();
        estadoNovo.setNOME("Bahia");
        estadoNovo.setPais(pais);

        repository.save(estadoNovo);

        assertEquals( estado, repository.findByNOME("Roraima") );
        assertEquals( estadoNovo, repository.findByNOME("Bahia") );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmEstadoNoBanco() {
        estado.setNOME("Espirito Santo");
        estado.setID_ESTADO(estadoBanco.getID_ESTADO());

        repository.save(estado);

        assertEquals( estado, repository.findByNOME("Espirito Santo") );
    }

    @Test
    public void deletarUmEstadoNoBanco() {
        repository.delete(estado);

        assertNull( repository.findByNOME("Roraima") );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodosEstadosNoBanco() {
        assertEquals( estado, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmEstadoNoBanco() {
        assertEquals( estado, repository.findByNOME("Roraima") );
    }

}
