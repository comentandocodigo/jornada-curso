package br.com.comentandocodigo.JornadaZeroAoMercado.Service;

import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.GenericEntity;
import br.com.comentandocodigo.JornadaZeroAoMercado.Entity.Pais;
import br.com.comentandocodigo.JornadaZeroAoMercado.Repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<
        R extends CrudRepository<E, T>,
        E extends GenericEntity<T>,
        T> {

    @Autowired
    private R respository;

    /*
     * Find All entity in database;
     *
     * */
    public List<E> allEntity() {
        return (List<E>) respository.findAll();
    }

    /*
     * Create one entity in database
     *
     * */
    @Transactional( rollbackFor = Exception.class )
    public E createEntity( E entity ) {
        return respository.save(entity);
    }

    /*
     * Delete one entity by id in database
     *
     * */
    public void deleteEntityById( T id ) {
        respository.deleteById(id);
    }

    /*
     * Find one entity by id in database
     *
     * */
    public E findEntityById( T id ) {
        Optional<E> entityByData = respository.findById(id);
        return entityByData.isEmpty() ? null : entityByData.get();

        //return respository.findById(id).get();
    }

    /*
     * Update one entity in database
     *
     * */
    @Transactional( rollbackFor = Exception.class )
    public E updateEntity( E entity, T id ) {
        entity.setId(id);
        return respository.save(entity);
    }
}