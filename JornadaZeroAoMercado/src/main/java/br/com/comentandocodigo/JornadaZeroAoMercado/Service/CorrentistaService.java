package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Correntista;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.CorrentistaRepository;
import org.springframework.stereotype.Service;

@Service
public class CorrentistaService extends GenericService<CorrentistaRepository, Correntista, Integer> {
}
