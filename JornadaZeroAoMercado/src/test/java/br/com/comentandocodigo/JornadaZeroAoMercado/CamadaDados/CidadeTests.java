package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Cidade;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Estado;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.CidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class CidadeTests {

    @Autowired
    CidadeRepository repository;

    Estado estado = new Estado();
    Cidade cidade = new Cidade();
    Cidade cidadeBanco;

    @BeforeEach
    void init() {
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        estado.setNOME("Amazonas");
        estado.setPais(pais);

        cidade.setNome("Manaus");
        cidade.setEstado(estado);

        cidadeBanco = repository.save(cidade);
    }

    @Test
    public void adicionarUmaCidadeNoBanco() {
        Cidade cidadeNova = new Cidade();
        cidadeNova.setNome("Borba");
        cidadeNova.setEstado(estado);

        repository.save(cidadeNova);

        assertEquals( cidade, repository.findById(cidadeBanco.getID_Cidade()).get() );
        assertEquals( cidadeNova, repository.findByNome("Borba") );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmaCidadeNoBanco() {
        cidade.setNome("Borba");
        cidade.setID_Cidade(cidadeBanco.getID_Cidade());

        repository.save(cidade);

        assertEquals( cidade, repository.findByNome("Borba") );
    }

    @Test
    public void deletarUmaCidadeNoBanco() {
        repository.delete(cidade);

        assertNull( repository.findByNome("Manaus") );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodasCidadesNoBanco() {
        assertEquals( cidade, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmaCidadeNoBanco() {
        assertEquals( cidade, repository.findByNome("Manaus") );
        assertEquals( cidade, repository.findById(cidadeBanco.getID_Cidade()).get() );
    }

}
