/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.command;

import com.br.lp3.model.dao.AutorDAO;
import com.br.lp3.model.entities.Autor;
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
public class AutorCommand implements Command {

    AutorDAO autorDAO = lookupAutorDAOBean();

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String returnPage = "WEB-INF/jsp/autor/visualizar.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        /* ABRE CONEXÃO */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("colecionador_pu");
        EntityManager em = emf.createEntityManager();
        autorDAO.setEm(em);
        em.getTransaction().begin();

        String action = request.getParameter("action");
        String nomeAutor;
        Long idAutor;
        Autor autor;

        switch (action) {

            case "alterar":
                request.getSession().setAttribute("autores", autorDAO.read());

                returnPage = "WEB-INF/jsp/autor/alterar.jsp";
                break;

            case "alterar.confirmar":
                idAutor = Long.parseLong(request.getParameter("autores"));
                nomeAutor = request.getParameter("nomeAutor");

                autor = autorDAO.readById(idAutor);
                autor.setNomeautor(nomeAutor);

                request.getSession().setAttribute("autores", autorDAO.read());
                request.getSession().setAttribute("erromsg", "Alterado com sucesso");
                break;

            case "inserir":
                returnPage = "WEB-INF/jsp/autor/inserir.jsp";
                break;

            case "inserir.confirmar":
                nomeAutor = request.getParameter("nomeAutor");

                autor = new Autor();
                autor.setNomeautor(nomeAutor);
                autorDAO.persist(autor);

                request.getSession().setAttribute("autores", autorDAO.read());
                break;

            case "remover":
                request.getSession().setAttribute("autores", autorDAO.read());

                returnPage = "WEB-INF/jsp/autor/remover.jsp";
                break;

            case "remover.confirmar":
                idAutor = Long.parseLong(request.getParameter("autores"));

                autor = autorDAO.readById(idAutor);
                autorDAO.remove(autor);

                request.getSession().setAttribute("autores", autorDAO.read());
                break;

            case "visualizar":
                request.getSession().setAttribute("autores", autorDAO.read());
                break;
            default:
                break;
        }

        /* FECHA CONEXÃO */
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

}
