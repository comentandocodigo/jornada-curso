package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Movimentacao;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService extends GenericService<MovimentacaoRepository, Movimentacao, Integer> {
}
