package br.com.comentandocodigo.JornadaZeroAoMercado.Integracao;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.PaisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PaisIntegracaoTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaisRepository repository;

    @BeforeEach
    void init() {
        Pais pais = new Pais();
        pais.setID_PAIS(1);
        pais.setNOME("Brasil");
        Pais pais2 = new Pais();
        pais2.setID_PAIS(2);
        pais2.setNOME("Argentina");
        List<Pais> lstPais = List.of(pais, pais2);

        when( repository.findById(1) ).thenReturn(Optional.of(pais));
        when( repository.findAll() ).thenReturn(lstPais);
    }

    @Test
    public void quandoChamadaOEndpointDeFormaCorretaRetornarStatus200() throws Exception {
        this.mockMvc
                .perform( get("/api/pais/all") )
                .andExpect( status().isOk() );
    }

    @Test
    public void quandoBuscarPaisPeloIdCorretoTrazerObjetoParaValidarDados() throws Exception {
        this.mockMvc
                .perform( get("/api/pais/find/1") )
                .andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath("$.id_PAIS").value(1) )
                .andExpect( jsonPath("$.nome").value("Brasil") );
    }

    @Test
    public void quandoBuscarTodosPaisesTrazerListaParaValidarDados() throws Exception {
        this.mockMvc
                .perform( get("/api/pais/all") )
                .andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath("$[0].id_PAIS").value(1) )
                .andExpect( jsonPath("$[0].nome").value("Brasil") )
                .andExpect( jsonPath("$[1].id_PAIS").value(2) )
                .andExpect( jsonPath("$[1].nome").value("Argentina") );
    }

    /*{
        id_PAIS: 1
        nome: "Brasil"
      }* */
    @Test
    public void adicionarNovoPaisMandandoPeloEndpointRetornoStatus200() throws Exception {
        Pais pais = new Pais();
        pais.setID_PAIS(1);
        pais.setNOME("Brasil");

        String requestJson = new ObjectMapper().writeValueAsString(pais);

        this.mockMvc.perform( post("/api/pais/new").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson) )
                .andExpect( status().isOk() );
    }

    @Test
    public void editarPaisMandandoPeloEndpointRetornoStatus200() throws Exception {
        Pais pais = new Pais();
        pais.setNOME("Argentina");

        String requestJson = new ObjectMapper().writeValueAsString(pais);

        this.mockMvc.perform( put("/api/pais/edit/2").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson) )
                .andExpect( status().isOk() );
    }

}
