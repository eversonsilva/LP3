/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Autor;
import com.br.lp3.model.entities.Emprestimo;
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
public class EmprestimoDAO implements GenericDAO<Emprestimo>{

    private EntityManager em;
    
    @Override
    public void persist(Emprestimo e) {
        em.persist(e);
    }

    @Override
    public List<Emprestimo> read() {
        return em.createNamedQuery("Emprestimo.findAll", Emprestimo.class).getResultList();
    }

    @Override
    public Emprestimo readById(Long id) {
        return em.find(Emprestimo.class, id);
    }

    @Override
    public Emprestimo readByName(String name) {
        return em.find(Emprestimo.class, name);
    }

    @Override
    public void remove(Emprestimo e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
