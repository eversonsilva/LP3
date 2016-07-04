/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Autor;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Everson
 */
@Stateless
@LocalBean
public class AutorDAO implements GenericDAO<Autor> {

    private EntityManager em;

    @Override
    public void persist(Autor e) {
        em.persist(e);
    }

    @Override
    public List<Autor> read() {
        return em.createNamedQuery("Autor.findAll", Autor.class).getResultList();
    }

    @Override
    public Autor readById(Long id) {
        return em.find(Autor.class, id);
    }

    @Override
    public Autor readByName(String name) {
        return em.find(Autor.class, name);
    }

    @Override
    public void remove(Autor e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }

}
