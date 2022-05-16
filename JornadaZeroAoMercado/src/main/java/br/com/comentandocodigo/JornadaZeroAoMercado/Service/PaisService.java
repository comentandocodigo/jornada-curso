package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.PaisRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService extends GenericService<PaisRepository, Pais, Integer> {

    /*
    //Para fins de consulta do objeto sendo manipulado antes de buscar.
    public List<Pais> allCountry() {
        List<Pais> country = respository.findAll();
        return country;
        return respository.findAll();
    }*/

}
