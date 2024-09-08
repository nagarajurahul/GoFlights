package com.rnagaraju.goflights.service;

/*
 * AbstractService.java
 *
 * Abstract service class for entity management.
 * Author: rahul
 * This service contains all the necessary methods to handle all entities.
 */

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 * AbstractService
 *
 * Abstract service class for entity management.
 * Author: rahul
 * This service contains all the necessary methods to handle all entities.
 * @param <T> The type of entity managed by this service.
 */
// Stateless NO-Interface EJB
//@Stateless
public abstract class AbstractService<T> {

    /**
     * Entity manager for database interaction.
     */
    @PersistenceContext(name="itmd4515PU")
    protected EntityManager em;

    /**
     * The class of the entity.
     */
    protected Class<T> entityClass;

    /**
     * Default constructor.
     */
    protected AbstractService() {

    }

    /**
     * Constructor with entity class parameter.
     * @param entityClass
     */
    protected AbstractService(Class<T> entityClass) {
        this.entityClass=entityClass;
    }

    /**
     * Method to create a new entity.
     * @param entity The entity object to be created.
     */
    public void create(T entity){
        em.persist(entity);
    }

    /**
     * Method to read an entity by its ID.
     * @param id The ID of the entity to be read.
     * @return The entity object.
     */
    public T read(Long id){
        return em.find(entityClass, id);
    }

    /**
     * Method to update an existing entity.
     * @param entity The entity object to be updated.
     */
    public void update(T entity){
        em.merge(entity);
    }

    /**
     * Method to delete an existing entity.
     * @param entity The entity object to be deleted.
     */
    public void delete(T entity){
        em.remove(em.merge(entity));
    }

    /**
     * Method to find all entities using a named query.
     * @param namedQueryName The name of the named query.
     * @return A list of entities.
     */
    protected List<T> findAll(String namedQueryName){
        return em.createNamedQuery(namedQueryName, entityClass).getResultList();
    }

    /**
     * Method to find all entities by a specified parameter using a named query.
     * @param namedQueryName The name of the named query.
     * @param parameter The parameter name.
     * @param parameterValue The value of the parameter.
     * @return A list of entities.
     */
    protected List<T> findAllByParamater(String namedQueryName, String parameter, String parameterValue){
        return em.createNamedQuery(namedQueryName, entityClass).setParameter(parameter,parameterValue).getResultList();
    }

}
