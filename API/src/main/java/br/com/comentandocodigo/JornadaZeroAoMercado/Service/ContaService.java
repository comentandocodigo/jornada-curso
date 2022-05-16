package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Conta;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService extends GenericService<ContaRepository, Conta, Integer> {
}
