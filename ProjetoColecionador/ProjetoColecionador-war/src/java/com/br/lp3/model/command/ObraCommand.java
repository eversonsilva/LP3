/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.command;

import com.br.lp3.model.dao.AutorDAO;
import com.br.lp3.model.dao.ObraDAO;
import com.br.lp3.model.entities.Autor;
import com.br.lp3.model.entities.Obra;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
public class ObraCommand implements Command{
    ObraDAO obraDAO = lookupObraDAOBean();
    AutorDAO autorDAO = lookupAutorDAOBean();
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String returnPage = "WEB-INF/jsp/obra/visualizar.jsp;";
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("colecionador_pu");
        EntityManager em = emf.createEntityManager();
        autorDAO.setEm(em);
        obraDAO.setEm(em);
        em.getTransaction().begin();

        String action = request.getParameter("action");
        String nomeObra;
        Long idObra;
        Long idAutor;
        Obra obra;
        Autor autor;
        switch(action){
            
            case "alterar":
                request.getSession().setAttribute("obras", obraDAO.read());
                request.getSession().setAttribute("autores", autorDAO.read());
                
                returnPage = "WEB-INF/jsp/obra/alterar.jsp";
                break;
                
            case "alterar.confirmar":
                
                idObra = Long.parseLong(request.getParameter("obras"));
                nomeObra = request.getParameter("nomeObra");
                idAutor = Long.parseLong(request.getParameter("autores"));
                
                autor = autorDAO.readById(idAutor);
                obra = obraDAO.readById(idObra);
                obra.setNomeobra(nomeObra);
                obra.setIdAutor(autor);
                
                request.getSession().setAttribute("obras", obraDAO.read());
                break;
                
            case "inserir":
                request.getSession().setAttribute("autores", autorDAO.read());
                
                returnPage = "WEB-INF/jsp/obra/inserir.jsp";
                break;
                
            case "inserir.confirmar":
                nomeObra = request.getParameter("nomeObra");
                idAutor = Long.parseLong(request.getParameter("autores"));
                
                autor = autorDAO.readById(idAutor);
                obra = new Obra();
                obra.setNomeobra(nomeObra);
                obra.setIdAutor(autor);
                obraDAO.persist(obra);
                
                request.getSession().setAttribute("obras", obraDAO.read());
                break;
                
            case "remover":
                request.getSession().setAttribute("obras", obraDAO.read());
                
                returnPage = "WEB-INF/jsp/obra/remover.jsp";
                break;
                
            case "remover.confirmar":
                idObra = Long.parseLong(request.getParameter("obras"));
                nomeObra = request.getParameter("nomeObra");
                
                obra = obraDAO.readById(idObra);
                obra.setNomeobra(nomeObra);
                obraDAO.remove(obra);
                
                request.getSession().setAttribute("obras", obraDAO.read());
                break;
                
            case "visualizar":
                request.getSession().setAttribute("obras", obraDAO.read());
                break;
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private AutorDAO lookupAutorDAOBean() {
        try {
            Context c = new InitialContext();
            return (AutorDAO) c.lookup("java:global/ProjetoColecionador/ProjetoColecionador-ejb/AutorDAO!com.br.lp3.model.dao.AutorDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ObraDAO lookupObraDAOBean() {
        try {
            Context c = new InitialContext();
            return (ObraDAO) c.lookup("java:global/ProjetoColecionador/ProjetoColecionador-ejb/ObraDAO!com.br.lp3.model.dao.ObraDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
