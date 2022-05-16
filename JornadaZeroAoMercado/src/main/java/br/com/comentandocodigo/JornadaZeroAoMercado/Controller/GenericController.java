package br.com.comentandocodigo.JornadaZeroAoMercado.Controller;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.GenericEntity;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.GenericService;
import br.com.comentandocodigo.JornadaZeroAoMercado.Service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<
        S extends GenericService<R, E, T>,
        R extends CrudRepository<E, T>,
        E extends GenericEntity<T>,
        T> {

    @Autowired
    private S service;

    @GetMapping("/all")
    @ResponseBody
    public List<E> findAllExposedApi() {
        return service.allEntity();
    }

    @PostMapping("/new")
    @ResponseBody
    public E createExposedApi(@RequestBody E entity) {
        return service.createEntity(entity);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public E editExposedApi(@RequestBody E entity, @PathVariable T id) {
        return service.updateEntity(entity, id);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public E findOneExposedApi( @PathVariable T id ) {
        return service.findEntityById(id);
    }

}
