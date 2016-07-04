/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Obra;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Everson
 */

@Stateless
@LocalBean
public class ObraDAO implements GenericDAO<Obra>{
    
    private EntityManager em; 

    @Override
    public void persist(Obra e) {
        em.persist(e);
    }

    @Override
    public List<Obra> read() {
        return em.createNamedQuery("Obra.findAll", Obra.class).getResultList();
    }

    @Override
    public Obra readById(Long id) {
        return em.find(Obra.class, id);
    }

    @Override
    public Obra readByName(String name) {
        return em.find(Obra.class, name);
    }

    @Override
    public void remove(Obra e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
