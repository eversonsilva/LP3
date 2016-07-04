package com.br.lp3.model.dao;

import java.util.List;

/**
 *
 * @author Everson
 */
public interface GenericDAO<E> {
    
    public void create(E e);
    public List<E> read();
    public E readById(long id);
    public void update(E e);
    public void delete(E e);
    
}
