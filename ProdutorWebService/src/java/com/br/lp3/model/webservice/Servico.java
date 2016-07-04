/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.webservice;

import com.br.lp3.model.dao.GenericDAO;
import com.br.lp3.model.entities.Spoiler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Everson
 */
@Stateless
@Path("spoiler")
public class Servico {

    @EJB
    private GenericDAO spoilerDAO;

    @GET
    @Produces({"application/xml"})
    public List<Spoiler> findAll() {
        return spoilerDAO.read();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("buscarid/{id}")
    public Spoiler findById(@PathParam("id") long id) {
        return (Spoiler) spoilerDAO.readById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("autor/{autor}")
    public List<Spoiler> findByAutor(@PathParam("autor") String autor) {
        return spoilerDAO.readByAutor(autor);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("serie/{serie}")
    public List<Spoiler> findBySerie(@PathParam("serie") String serie) {
        return spoilerDAO.readBySerie(serie);
    }

    @GET
    @Path("ano/{ano}")
    @Produces({"application/json", "application/xml"})
    public List<Spoiler> getByAno(@PathParam("ano") Integer ano) {
        
        Calendar cal = Calendar.getInstance();
        List<Spoiler> lista1 = spoilerDAO.read();
        List<Spoiler> lista2 = new ArrayList<>();
        
        for (Spoiler spoiler : lista1) {
            cal.setTime(spoiler.getDataSpoiler());
            if(cal.get(Calendar.YEAR) == ano){
                lista2.add(spoiler);
            }
        }
        return lista2;
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("{from}/{to}")
    
    public List<Spoiler> findRange(@PathParam("from") long from, @PathParam("to") long to) {
        List<Spoiler> lista = spoilerDAO.read();
        List<Spoiler> lista2 = new ArrayList<>();
        for (Spoiler spoiler : lista) {
            if (spoiler.getIdSpoiler() >= from && spoiler.getIdSpoiler() <= to) {
                lista2.add(spoiler);
            }
        }
        return lista2;
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("count")
    public int count() {
        return spoilerDAO.read().size();
    }

}
