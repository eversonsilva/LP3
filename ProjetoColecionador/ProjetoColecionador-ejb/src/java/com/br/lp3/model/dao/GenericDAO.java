/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Everson
 * @param <E>
 */

public interface GenericDAO<E> {
    
    public void persist(E e);
    public List<E> read();
    public E readById(Long id);
    public E readByName(String name);
    public void remove(E e);
    
    public void setEm(EntityManager em);
    
}
