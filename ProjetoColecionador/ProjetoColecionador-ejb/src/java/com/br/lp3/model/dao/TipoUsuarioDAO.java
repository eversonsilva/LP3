/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Tipousuario;
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
public class TipoUsuarioDAO implements GenericDAO<Tipousuario>{
    
    private EntityManager em;

    @Override
    public void persist(Tipousuario e) {
        em.persist(e);
    }

    @Override
    public List<Tipousuario> read() {
        return em.createNamedQuery("Tipousuario.findAll", Tipousuario.class).getResultList();
    }

    @Override
    public Tipousuario readById(Long id) {
        return em.find(Tipousuario.class, id);
    }

    @Override
    public Tipousuario readByName(String name) {
        return em.find(Tipousuario.class, name);
    }

    @Override
    public void remove(Tipousuario e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    
}
