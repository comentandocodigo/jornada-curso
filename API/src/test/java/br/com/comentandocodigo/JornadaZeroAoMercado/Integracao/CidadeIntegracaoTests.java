package br.com.comentandocodigo.JornadaZeroAoMercado.Integracao;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Cidade;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Estado;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.CidadeRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CidadeIntegracaoTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CidadeRepository repository;

    Estado estado = new Estado();

    @BeforeEach
    void init() {
        Pais pais = new Pais();
        pais.setID_PAIS(1);
        pais.setNOME("Brasil");

        estado.setPais(pais);
        estado.setID_ESTADO(1);
        estado.setNOME("Rio Grande do Sul");

        Cidade cidade = new Cidade(1, "Porto Alegre", estado);
        Cidade cidade2 = new Cidade(2, "Gramado", estado);

        List<Cidade> lstCidades = List.of(cidade, cidade2);

        when( repository.findById(1) ).thenReturn( Optional.of(cidade) );
        when( repository.findAll() ).thenReturn( lstCidades );
    }

    @Test
    public void chamadaParaEndpointTodasAsCidadesRetornar200() throws Exception {
        this.mockMvc.perform( get("/api/cidade/all") )
                .andExpect( status().isOk() );
    }

    @Test
    public void quandoBuscarCidadePeloIdCorretoTrazerObjetoParaValidarDados() throws Exception {
        this.mockMvc
                .perform( get("/api/cidade/find/1") )
                .andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath("$.id_Cidade").value(1) )
                .andExpect( jsonPath("$.nome").value("Porto Alegre") );
    }

    @Test
    public void quandoBuscarTodasCidadesTrazerListaParaValidarDados() throws Exception {
        this.mockMvc
                .perform( get("/api/cidade/all") )
                .andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath("$[0].id_Cidade").value(1) )
                .andExpect( jsonPath("$[0].nome").value("Porto Alegre") )
                .andExpect( jsonPath("$[1].id_Cidade").value(2) )
                .andExpect( jsonPath("$[1].nome").value("Gramado") );
    }

    @Test
    public void adicionarNovaCidadeMandandoPeloEndpointRetornoStatus200() throws Exception {
        Cidade cidadeNova = new Cidade(3, "Caxias", estado);

        String requestJson = new ObjectMapper().writeValueAsString(cidadeNova);

        this.mockMvc.perform( post("/api/cidade/new").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson) )
                .andExpect( status().isOk() );
    }

    @Test
    public void editarCidadeMandandoPeloEndpointRetornoStatus200() throws Exception {
        Cidade cidadeNova = new Cidade(2, "Santa Maria", estado);

        String requestJson = new ObjectMapper().writeValueAsString(cidadeNova);

        this.mockMvc.perform( put("/api/cidade/edit/2").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson) )
                .andExpect( status().isOk() );
    }

}
