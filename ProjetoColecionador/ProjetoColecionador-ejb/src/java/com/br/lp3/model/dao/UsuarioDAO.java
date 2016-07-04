/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Usuario;
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
public class UsuarioDAO implements GenericDAO<Usuario>{
    
    private EntityManager em;

    @Override
    public void persist(Usuario e) {
        em.persist(e);
    }

    @Override
    public List<Usuario> read() {
        return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
    }

    @Override
    public Usuario readById(Long id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public Usuario readByName(String name) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.userusuario=:name",Usuario.class).setParameter("name", name).getSingleResult();
    }
    
    public Usuario readByNameAndPassword(String name, String senha) {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.userusuario=:name AND u.senhausuario=:senha",Usuario.class).setParameter("name", name).setParameter("senha", senha);
        if(query.getResultList().isEmpty()){
            return null;
        }
        return (Usuario)query.getSingleResult();
    }
    
    @Override
    public void remove(Usuario e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
 
}
