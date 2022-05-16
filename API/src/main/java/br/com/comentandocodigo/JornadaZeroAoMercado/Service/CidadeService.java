package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Cidade;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.CidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class CidadeService extends GenericService<CidadeRepository, Cidade, Integer> {
}
