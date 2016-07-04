/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Userinfo;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Everson
 */

@Stateful
public class UserInfoDAO implements GenericDAO<Userinfo>{
    
    @PersistenceContext(unitName = "lp3_pu", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Userinfo e) {
        em.persist(e);
    }

    @Override
    public List<Userinfo> find() {
        return em.createNamedQuery("Userinfo.findAll", Userinfo.class).getResultList();
    }

    @Override
    public Userinfo findById(long id) {
        return em.find(Userinfo.class, id);//
        //EAGER - find() -- constroi o obejto inteiro
        //LAZY - getRefence() -- constroi só com id, e de acordo com a sua necessidade, ele vai preenchendo cada um com o que vc procurar, pesquisando no banco sempre
    }

    @Override
    public void remove(Userinfo e) {
        em.remove(e);
    }
    
}
