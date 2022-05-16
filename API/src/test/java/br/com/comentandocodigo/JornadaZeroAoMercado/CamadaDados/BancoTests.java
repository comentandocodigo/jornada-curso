package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.*;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.BairroRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.BancoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class BancoTests {

    @Autowired
    BancoRepository repository;

    Banco banco = new Banco();
    Banco bancoBanco;

    @BeforeEach
    void init() {
        banco.setNOME("Jornada Bank");

        bancoBanco = repository.save(banco);
    }

    @Test
    public void adicionarUmBancoNoBanco() {
        Banco bancoNovo = new Banco();
        bancoNovo.setNOME("Jornada Banco");

        repository.save(bancoNovo);

        assertEquals( banco, repository.findById(bancoBanco.getCODIGO()).get() );
        assertEquals( bancoNovo, repository.findByNOME("Jornada Banco") );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmBancoNoBanco() {
        banco.setNOME("Jornada Banco");
        banco.setCODIGO(bancoBanco.getCODIGO());

        repository.save(banco);

        assertEquals( banco, repository.findByNOME("Jornada Banco") );
    }

    @Test
    public void deletarUmBancoNoBanco() {
        repository.delete(banco);

        assertNull( repository.findByNOME("Jornada Bank") );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodosBancosNoBanco() {
        assertEquals( banco, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmBancoNoBanco() {
        assertEquals( banco, repository.findByNOME("Jornada Bank") );
        assertEquals( banco, repository.findById(bancoBanco.getCODIGO()).get() );
    }
}
