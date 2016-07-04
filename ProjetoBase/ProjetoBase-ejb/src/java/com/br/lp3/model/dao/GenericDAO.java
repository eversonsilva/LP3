/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Everson
 * @param <E>
 */

public interface GenericDAO<E> {
    
    public void persist(E e);//create - update
    public List<E> find();//read
    public E findById(long id);
    public void remove(E e);//remove
    
}
