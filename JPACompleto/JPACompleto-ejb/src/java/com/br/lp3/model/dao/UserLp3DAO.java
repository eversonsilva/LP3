package com.br.lp3.model.dao;

import com.br.lp3.entities.UserLp3;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Everson
 */
public class UserLp3DAO implements GenericDAO<UserLp3> {

    private EntityManager em;
    
    public UserLp3DAO(){
        em = Persistence.createEntityManagerFactory("jpa_completo").createEntityManager();
    }

    @Override
    public void create(UserLp3 e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    @Override
    public List<UserLp3> read() {
        return em.createQuery("SELECT u FROM UserLp3 u", UserLp3.class).getResultList();
    }

    @Override
    public UserLp3 readById(long id) {
        return (UserLp3) em.createQuery("SELECT u FROM UserLp3 u WHERE id_user =: i").setParameter("i", id).getSingleResult();
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


