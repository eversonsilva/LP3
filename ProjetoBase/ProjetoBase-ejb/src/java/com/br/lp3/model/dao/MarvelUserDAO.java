/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.exceptions.DBException;
import com.br.lp3.exceptions.DBExceptionEnum;
import com.br.lp3.model.entities.Marveluser;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author 1147106
 */
@Stateless
@LocalBean
public class MarvelUserDAO implements GenericDAO<Marveluser> {

    @PersistenceContext(unitName = "lp3_pu", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Marveluser e) {
        try {
            em.persist(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
    }

    @Override
    public List<Marveluser> find() {
        List<Marveluser> lista = em.createNamedQuery("Marveluser.findAll", Marveluser.class).getResultList();
        if (lista == null || lista.isEmpty()) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return lista;
    }

    @Override
    public Marveluser findById(long id) {
        Marveluser user = em.find(Marveluser.class, id);
        if (user == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return user;
    }

    public Marveluser findByName(String name) {
        Marveluser user = null;
        List<Marveluser> lista = em.createNamedQuery("Marveluser.findByUsername", Marveluser.class).setParameter("username", name).getResultList();
        if (lista != null && !lista.isEmpty()) {
            user = lista.get(0);
        }
        if (lista == null || lista.isEmpty() || user == null) {
            throw new DBException(DBExceptionEnum.FIND_ERROR);
        }
        return user;
    }

    @Override
    public void remove(Marveluser e) {
        try {
            em.remove(e);
        } catch (Exception ex) {
            throw new DBException(DBExceptionEnum.REMOVE_ERROR);
        }
    }

}
