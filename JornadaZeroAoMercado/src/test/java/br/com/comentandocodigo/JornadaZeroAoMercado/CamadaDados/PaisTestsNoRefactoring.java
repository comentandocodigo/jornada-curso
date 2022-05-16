package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.PaisRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class PaisTestsNoRefactoring {

    @Autowired
    PaisRepository repository;

    @BeforeEach
    void init() {
        /* Criação de um novo objeto de pais */
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        // Manipulação do objeto no banco
        Pais paisBanco = repository.save(pais);
    }

    /*@BeforeAll
    public static void setup() {

    }

    @AfterEach
    void finish() {

    }

    @AfterAll
    public static void tearDown() {

    }*/


    @Test
    public void adicionarUmPaisNoBanco() {
        /* Criação de um novo objeto de pais */
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        // Manipulação do objeto no banco
        repository.save(pais);

        // Validação do resultado do teste
        assertEquals( pais, repository.findByNOME("Brasil") );
    }

    @Test
    public void editarUmPaisNoBanco() {
        /* Criação de um novo objeto de pais */
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        // Manipulação do objeto no banco
        Pais paisBanco = repository.save(pais);

        // Validação do resultado do teste
        assertEquals( pais, repository.findByNOME("Brasil") );

        /* edição de um novo objeto de pais */
        pais.setNOME("Argentina");
        pais.setID_PAIS(paisBanco.getID_PAIS());

        // Manipulação do objeto no banco
        repository.save(pais);

        // Validação do resultado do teste
        assertEquals( pais, repository.findByNOME("Argentina") );
    }

    @Test
    public void deletarUmPaisNoBanco() {
        /* Criação de um novo objeto de pais */
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        // Manipulação do objeto no banco
        Pais paisBanco = repository.save(pais);

        // Validação do resultado do teste
        assertEquals( pais, repository.findByNOME("Brasil") );

        // Manipulação do objeto no banco
        repository.deleteById(paisBanco.getID_PAIS());

        // Validação do resultado do teste
        assertEquals( 0, repository.findAll().size() );
        assertNull(repository.findByNOME("Brasil"));
    }

    @Test
    public void buscarTodosOsPaisesNoBanco() {
        /* Criação de um novo objeto de pais */
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        // Manipulação do objeto no banco
        repository.save(pais);

        // Validação do resultado do teste
        assertEquals( 1, repository.findAll().size() );
        assertEquals( pais, repository.findAll().get(0) );
    }

    @Test
    public void buscarUmPaisNoBanco() {
        /* Criação de um novo objeto de pais */
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        // Manipulação do objeto no banco
        Pais paisBanco = repository.save(pais);

        // Validação do resultado do teste
        assertEquals( pais, repository.findById(paisBanco.getID_PAIS()).get() );
    }
}