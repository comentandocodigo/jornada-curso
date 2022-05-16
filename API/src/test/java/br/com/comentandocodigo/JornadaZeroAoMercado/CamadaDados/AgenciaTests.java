package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.*;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.AgenciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class AgenciaTests {

    @Autowired
    AgenciaRepository repository;

    Banco banco = new Banco();
    Endereco endereco = new Endereco();
    Agencia agencia = new Agencia();
    Agencia agenciaBanco;

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

        banco.setNOME("Jornada Bank");

        agencia.setNOME("Agencia Web");
        agencia.setBanco(banco);
        agencia.setEndereco(endereco);

        agenciaBanco = repository.save(agencia);
    }

    @Test
    public void adicionarUmaAgenciaNoBanco() {
        Agencia agenciaNova = new Agencia();
        agenciaNova.setNOME("Agencia Fisica");
        agenciaNova.setEndereco(endereco);

        repository.save(agenciaNova);

        assertEquals( agencia, repository.findById(agencia.getCODIGO()).get() );
        assertEquals( agenciaNova, repository.findByNOME("Agencia Fisica") );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmaAgenciaNoBanco() {
        agencia.setNOME("Agencia Fisica");
        agencia.setCODIGO(agenciaBanco.getCODIGO());

        repository.save(agencia);

        assertEquals( agencia, repository.findByNOME("Agencia Fisica") );
    }

    @Test
    public void deletarUmaAgenciaNoBanco() {
        repository.delete(agencia);

        assertNull( repository.findByNOME("Agencia Web") );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodasAgenciasNoBanco() {
        assertEquals( agencia, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmaAgenciaNoBanco() {
        assertEquals( agencia, repository.findByNOME("Agencia Web") );
        assertEquals( agencia, repository.findById(agenciaBanco.getCODIGO()).get() );
    }
}
