package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.*;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.BairroRepository;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class EnderecoTests {

    @Autowired
    EnderecoRepository repository;

    Bairro bairro = new Bairro();
    Endereco endereco = new Endereco();
    Endereco enderecoBanco;

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

        bairro.setNOME("Centro");
        bairro.setCidade(cidade);

        endereco.setLOUGRADOURO("Testando o lougradouro");
        endereco.setNUMERO(11);
        endereco.setCEP("00000-000");
        endereco.setBairro(bairro);
        endereco.setCOMPLEMENTO("apto 001");

        enderecoBanco = repository.save(endereco);
    }

    @Test
    public void adicionarUmEnderecoNoBanco() {
        Endereco enderecoNovo = new Endereco();
        enderecoNovo.setLOUGRADOURO("Mudando o lougradouro");
        enderecoNovo.setNUMERO(22);
        enderecoNovo.setCEP("00001-001");
        enderecoNovo.setBairro(bairro);
        enderecoNovo.setCOMPLEMENTO("apto 101");

        repository.save(enderecoNovo);

        assertEquals( endereco, repository.findById(enderecoBanco.getID_ENDERECO()).get() );
        assertEquals( enderecoNovo, repository.findByLOUGRADOURO("Mudando o lougradouro") );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmEnderecoNoBanco() {
        endereco.setLOUGRADOURO("Mudando o lougradouro");
        endereco.setID_ENDERECO(enderecoBanco.getID_ENDERECO());

        repository.save(endereco);

        assertEquals( endereco, repository.findByLOUGRADOURO("Mudando o lougradouro") );
    }

    @Test
    public void deletarUmEnderecoNoBanco() {
        repository.delete(endereco);

        assertNull( repository.findByLOUGRADOURO("Testando o lougradouro") );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodosEnderecosNoBanco() {
        assertEquals( endereco, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmEnderecoNoBanco() {
        assertEquals( endereco, repository.findByLOUGRADOURO("Testando o lougradouro") );
        assertEquals( endereco, repository.findById(enderecoBanco.getID_ENDERECO()).get() );
    }
}
