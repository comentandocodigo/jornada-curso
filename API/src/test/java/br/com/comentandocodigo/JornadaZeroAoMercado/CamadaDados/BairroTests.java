package br.com.comentandocodigo.JornadaZeroAoMercado.CamadaDados;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Bairro;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Cidade;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Estado;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.BairroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class BairroTests {

    @Autowired
    BairroRepository repository;

    Cidade cidade = new Cidade();
    Bairro bairro = new Bairro();
    Bairro bairroBanco;

    @BeforeEach
    void init() {
        Pais pais = new Pais();
        pais.setNOME("Brasil");

        Estado estado = new Estado();
        estado.setNOME("Rio Grande do Sul");
        estado.setPais(pais);

        cidade.setNome("Porto alegre");
        cidade.setEstado(estado);

        bairro = new Bairro();
        bairro.setNOME("Centro");
        bairro.setCidade(cidade);

        bairroBanco = repository.save(bairro);
    }

    @Test
    public void adicionarUmBairroNoBanco() {
        Bairro bairroNovo = new Bairro();
        bairroNovo.setNOME("Moinhos");
        bairroNovo.setCidade(cidade);

        repository.save(bairroNovo);

        assertEquals( bairro, repository.findById(bairroBanco.getID_BAIRRO()).get() );
        assertEquals( bairroNovo, repository.findByNOME("Moinhos") );
        assertEquals( 2, repository.findAll().size() );
    }

    @Test
    public void editarUmBairroNoBanco() {
        bairro.setNOME("Moinhos");
        bairro.setID_BAIRRO(bairroBanco.getID_BAIRRO());

        repository.save(bairro);

        assertEquals( bairro, repository.findByNOME("Moinhos") );
    }

    @Test
    public void deletarUmBairroNoBanco() {
        repository.delete(bairro);

        assertNull( repository.findByNOME("Centro") );
        assertEquals( 0, repository.findAll().size() );
    }

    @Test
    public void buscarTodosBairrosNoBanco() {
        assertEquals( bairro, repository.findAll().get(0) );
        assertEquals( 1, repository.findAll().size() );
    }

    @Test
    public void buscarUmBairroNoBanco() {
        assertEquals( bairro, repository.findByNOME("Centro") );
        assertEquals( bairro, repository.findById(bairroBanco.getID_BAIRRO()).get() );
    }
}
