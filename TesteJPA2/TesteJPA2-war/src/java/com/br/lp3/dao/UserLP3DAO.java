/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.dao;

import com.br.lp3.entities.UserLp3;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Everson
 */
public class UserLP3DAO implements GenericDAO<UserLp3>{
    private EntityManager em;

    public UserLP3DAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LP3PU");
        em = emf.createEntityManager();
    }

    @Override
    public void create(UserLp3 e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    @Override
    public List<UserLp3> read() {
        Query query = em.createQuery("SELECT u FROM UserLp3 u");
        List<UserLp3> lista = query.getResultList();
        return lista;
    }

    @Override
    public UserLp3 readById(long id) {
        Query query = em.createQuery("SELECT u FROM UserLp3 u WHERE id_user=:id");
        query.setParameter("id", id);
        UserLp3 u = (UserLp3) query.getSingleResult();
        return u;
    }

    @Override
    public void update(UserLp3 e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    @Override
    public void delete(UserLp3 e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
   }
    
}
