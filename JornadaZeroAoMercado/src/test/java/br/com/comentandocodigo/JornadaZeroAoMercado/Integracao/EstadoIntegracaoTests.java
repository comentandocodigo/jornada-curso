package br.com.comentandocodigo.JornadaZeroAoMercado.Integracao;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Estado;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.EstadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class EstadoIntegracaoTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstadoRepository repository;

    Pais pais = new Pais();

    @BeforeEach
    void init() {
        pais.setID_PAIS(1);
        pais.setNOME("Brasil");

        Estado estado = new Estado();
        estado.setPais(pais);
        estado.setID_ESTADO(1);
        estado.setNOME("Rio Grande do Sul");

        Estado estado2 = new Estado();
        estado2.setPais(pais);
        estado2.setID_ESTADO(2);
        estado2.setNOME("Maranhão");

        List<Estado> lstEstados = List.of(estado, estado2);

        when( repository.findById(1) ).thenReturn( Optional.of(estado) );
        when( repository.findAll() ).thenReturn( lstEstados );
    }

    @Test
    public void chamadaParaEndpointTodosOsEstadosRetornar200() throws Exception {
        this.mockMvc.perform( get("/api/estado/all") )
                .andExpect( status().isOk() );
    }

    @Test
    public void quandoBuscarEstadoPeloIdCorretoTrazerObjetoParaValidarDados() throws Exception {
        this.mockMvc
                .perform( get("/api/estado/find/1") )
                .andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath("$.id_ESTADO").value(1) )
                .andExpect( jsonPath("$.nome").value("Rio Grande do Sul") );
    }

    @Test
    public void quandoBuscarTodosEstadosTrazerListaParaValidarDados() throws Exception {
        this.mockMvc
                .perform( get("/api/estado/all") )
                .andExpect( content().contentType(MediaType.APPLICATION_JSON_VALUE) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath("$[0].id_ESTADO").value(1) )
                .andExpect( jsonPath("$[0].nome").value("Rio Grande do Sul") )
                .andExpect( jsonPath("$[1].id_ESTADO").value(2) )
                .andExpect( jsonPath("$[1].nome").value("Maranhão") );
    }

    @Test
    public void adicionarNovoEstadoMandandoPeloEndpointRetornoStatus200() throws Exception {
        Estado estadoNovo = new Estado();
        estadoNovo.setPais(pais);
        estadoNovo.setID_ESTADO(3);
        estadoNovo.setNOME("São Paulo");

        String requestJson = new ObjectMapper().writeValueAsString(estadoNovo);

        this.mockMvc.perform( post("/api/estado/new").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson) )
                .andExpect( status().isOk() );
    }

    @Test
    public void editarEstadoMandandoPeloEndpointRetornoStatus200() throws Exception {
        Estado estadoNovo = new Estado();
        estadoNovo.setPais(pais);
        estadoNovo.setID_ESTADO(4);
        estadoNovo.setNOME("Sergipe");

        String requestJson = new ObjectMapper().writeValueAsString(estadoNovo);

        this.mockMvc.perform( put("/api/estado/edit/2").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestJson) )
                .andExpect( status().isOk() );
    }

}
