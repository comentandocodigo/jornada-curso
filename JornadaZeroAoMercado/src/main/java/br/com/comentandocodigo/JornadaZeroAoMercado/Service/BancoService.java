package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Banco;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.BancoRepository;
import org.springframework.stereotype.Service;

@Service
public class BancoService extends GenericService<BancoRepository, Banco, Integer> {
}
