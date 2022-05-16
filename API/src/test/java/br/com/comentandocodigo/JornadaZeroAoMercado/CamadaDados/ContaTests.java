package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.*;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ContaTests {

    @Autowired
    ContaRepository repository;

    Agencia agencia = new Agencia();
    Conta conta = new Conta();
    Conta contaBanco;

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

        Endereco endereco = new Endereco();
        endereco.setLOUGRADOURO("Testando o lougradouro");
        endereco.setNUMERO(11);
        endereco.setCEP("00000-000");
        endereco.setBairro(bairro);
        endereco.setCOMPLEMENTO("apto 001");

        Banco banco = new Banco();
        banco.setNOME("Jornada Bank");

        agencia.setNOME("Agencia Web");
        agencia.setBanco(banco);
        agencia.setEndereco(endereco);

        conta.setAgencia(agencia);
        conta.setSALDO(0.0);

        contaBanco = repository.save(conta);
    }

    @Test
    public void adicionarUmaContaNoBanco() {
        Conta contaNova = new Conta();
        contaNova.setAgencia(agencia);
        contaNova.setSALDO(1.1);

        Conta resposta = repository.save(contaNova);

        assertEquals( conta, repository.findById(contaBanco.getCODIGO()).get() );
        assertEquals( contaNova, repository.findById(resposta.getCODIGO()).get() );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmaContaNoBanco() {
        conta.setAgencia(agencia);
        conta.setSALDO(1.1);
        conta.setCODIGO(contaBanco.getCODIGO());

        repository.save(conta);

        assertEquals( conta, repository.findById(contaBanco.getCODIGO()).get() );
    }

    @Test
    public void deletarUmaContaNoBanco() {
        repository.delete(conta);

        assertTrue( repository.findById(contaBanco.getCODIGO()).isEmpty() );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodasContasNoBanco() {
        assertEquals( conta, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmaContaNoBanco() {
        assertEquals( conta, repository.findById(contaBanco.getCODIGO()).get() );
    }
}
