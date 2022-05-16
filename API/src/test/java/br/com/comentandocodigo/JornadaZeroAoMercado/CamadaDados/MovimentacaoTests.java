package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.*;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.MovimentacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MovimentacaoTests {

    @Autowired
    MovimentacaoRepository repository;

    Conta conta = new Conta();
    Movimentacao movimentacao = new Movimentacao();
    Movimentacao movimentacaoBanco;

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

        Agencia agencia = new Agencia();
        agencia.setNOME("Agencia Web");
        agencia.setBanco(banco);
        agencia.setEndereco(endereco);

        conta.setAgencia(agencia);
        conta.setSALDO(0.0);

        movimentacao.setConta(conta);
        movimentacao.setValor(100.00);
        movimentacao.setTiposMovimentacao(TiposMovimentacaoEnum.CREDITO);

        movimentacaoBanco = repository.save(movimentacao);
    }

    @Test
    public void adicionarUmaMovimentacaoNoBanco() {
        Movimentacao movimentacaoNova = new Movimentacao();
        movimentacaoNova.setConta(conta);
        movimentacaoNova.setValor(100.10);
        movimentacaoNova.setTiposMovimentacao(TiposMovimentacaoEnum.DEBITO);

        Movimentacao resposta = repository.save(movimentacaoNova);

        assertEquals( movimentacao, repository.findById(movimentacaoBanco.getID_MOVIMENTACAO()).get() );
        assertEquals( movimentacaoNova, repository.findById(resposta.getID_MOVIMENTACAO()).get() );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmaMovimentacaoNoBanco() {
        movimentacao.setConta(conta);
        movimentacao.setValor(100.10);
        movimentacao.setTiposMovimentacao(TiposMovimentacaoEnum.DEBITO);

        repository.save(movimentacao);

        assertEquals( movimentacao, repository.findById(movimentacaoBanco.getID_MOVIMENTACAO()).get() );
    }

    @Test
    public void deletarUmaMovimentacaoNoBanco() {
        repository.delete(movimentacao);

        assertTrue( repository.findById(movimentacaoBanco.getID_MOVIMENTACAO()).isEmpty() );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodasMovimentacoesNoBanco() {
        assertEquals( movimentacao, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmaMovimentacaoNoBanco() {
        assertEquals( movimentacao, repository.findById(movimentacaoBanco.getID_MOVIMENTACAO() ).get() );
    }
}
