package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.*;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.CorrentistaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CorrentistaTests {

    @Autowired
    CorrentistaRepository repository;

    Endereco endereco = new Endereco();
    Correntista correntista = new Correntista();
    Correntista correntistaBanco;

    @BeforeEach
    void init() {
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        Estado estado = new Estado();
        estado.setNOME("Rio Grande do Sul");
        estado.setPais(pais);

        Cidade cidade = new Cidade();
        cidade.setNome("Porto alegre");
        cidade.setEstado(estado);

        Bairro bairro = new Bairro();
        bairro.setNOME("Centro");
        bairro.setCidade(cidade);

        endereco.setLOUGRADOURO("Testando o lougradouro");
        endereco.setNUMERO(11);
        endereco.setCEP("00000-000");
        endereco.setBairro(bairro);
        endereco.setCOMPLEMENTO("apto 001");

        correntista.setNOME("Marcos Henrique");
        correntista.setCPF("000.000.000-00");
        correntista.setEndereco(new ArrayList<>(Arrays.asList( endereco ) ));

        correntistaBanco = repository.save(correntista);
    }

    @Test
    public void adicionarUmCorrentistaNoBanco() {
        Correntista correntistaNovo = new Correntista();
        correntistaNovo.setNOME("Marcos H");
        correntistaNovo.setCPF("000.000.000-11");
        correntistaNovo.setEndereco(new ArrayList<>(Arrays.asList( endereco ) ));

        repository.save(correntistaNovo);

        assertEquals( correntista, repository.findById(correntistaBanco.getID_CORRENTISTA()).get() );
        assertEquals( correntistaNovo, repository.findByNOME("Marcos H") );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmCorrentistaNoBanco() {
        correntista.setNOME("Marcos H");

        repository.save(correntista);

        assertEquals( correntista, repository.findByNOME("Marcos H") );
    }

    @Test
    public void deletarUmCorrentistaNoBanco() {
        repository.delete(correntista);

        assertNull( repository.findByNOME("Marcos H") );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodosCorrentistasNoBanco() {
        assertEquals( correntista, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmCorrentistaNoBanco() {
        assertEquals( correntista, repository.findByNOME("Marcos Henrique") );
    }
}
