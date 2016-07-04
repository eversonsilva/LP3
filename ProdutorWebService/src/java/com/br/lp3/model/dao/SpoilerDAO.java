/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Spoiler;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Everson
 */

@Stateless
public class SpoilerDAO implements GenericDAO<Spoiler>{
    
    @PersistenceContext(unitName = "PU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    
    @Override
    public void create(Spoiler e) {
        em.persist(e);
    }

    @Override
    public List<Spoiler> read() {
        return em.createNamedQuery("Spoiler.findAll", Spoiler.class).getResultList();
    }

    @Override
    public Spoiler readById(long id) {
        return em.find(Spoiler.class, id);
    }
    
    @Override
    public List<Spoiler> readByAutor(String autor) {
        return em.createNamedQuery("Spoiler.findByAutor", Spoiler.class).setParameter("autor", autor).getResultList();
    }
    
    @Override
    public List<Spoiler> readBySerie(String serie) {
        return em.createNamedQuery("Spoiler.findBySerie", Spoiler.class).setParameter("serie", serie).getResultList();
    }
    
    @Override
    public List<Spoiler> readByAno(Integer ano) {
        return em.createNamedQuery("Spoiler.findByDataSpoiler", Spoiler.class).setParameter("ano", ano).getResultList();
    }
    
    @Override
    public void update(Spoiler e) {
        em.merge(e);
    }

    @Override
    public void delete(Spoiler e) {
        em.remove(e);
    }
    
}
