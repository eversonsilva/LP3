/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Marvelmatch;
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
public class MarvelMatchDAO implements GenericDAO<Marvelmatch>{
    
    @PersistenceContext(unitName = "lp3_pu", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void persist(Marvelmatch e) {
        em.persist(e);
    }

    @Override
    public List<Marvelmatch> find() {
        return em.createNamedQuery("Marvelmatch.findAll", Marvelmatch.class).getResultList();
    }

    @Override
    public Marvelmatch findById(long id) {
        return em.find(Marvelmatch.class, id);//
        //EAGER - find() -- constroi o obejto inteiro
        //LAZY - getRefence() -- constroi só com id, e de acordo com a sua necessidade, ele vai preenchendo cada um com o que vc procurar, pesquisando no banco sempre
    }

    @Override
    public void remove(Marvelmatch e) {
        em.remove(e);
    }
    
}
