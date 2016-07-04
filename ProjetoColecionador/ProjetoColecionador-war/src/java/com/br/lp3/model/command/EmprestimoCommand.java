/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.command;

import com.br.lp3.model.dao.AutorDAO;
import com.br.lp3.model.dao.EmprestimoDAO;
import com.br.lp3.model.dao.ObraDAO;
import com.br.lp3.model.dao.UsuarioDAO;
import com.br.lp3.model.entities.Emprestimo;
import com.br.lp3.model.entities.Obra;
import com.br.lp3.model.entities.Usuario;
import java.util.Date;
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
public class EmprestimoCommand implements Command{
    AutorDAO autorDAO = lookupAutorDAOBean();
    EmprestimoDAO emprestimoDAO = lookupEmprestimoDAOBean();
    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();
    ObraDAO obraDAO = lookupObraDAOBean();

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String returnPage = "WEB-INF/jsp/emprestimo/visualizar.jsp;";
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("colecionador_pu");
        EntityManager em = emf.createEntityManager();
        emprestimoDAO.setEm(em);
        usuarioDAO.setEm(em);
        obraDAO.setEm(em);
        em.getTransaction().begin();
        
        String action = request.getParameter("action");
        Long idObra;
        Long idEmprestimo;
        Long idUsuario;
        Obra obra;
        Usuario usuario;
        Emprestimo emprestimo;
        
        switch(action){
            
            case "alterar":
                request.getSession().setAttribute("emprestimos", emprestimoDAO.read());
                request.getSession().setAttribute("obras", obraDAO.read());
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
                
                returnPage = "WEB-INF/jsp/emprestimo/alterar.jsp";
                break;
                
            case "alterar.confirmar":
                idEmprestimo = Long.parseLong(request.getParameter("emprestimos"));
                idObra = Long.parseLong(request.getParameter("obras"));
                idUsuario = Long.parseLong(request.getParameter("usuarios"));

                usuario = usuarioDAO.readById(idUsuario);
                obra = obraDAO.readById(idObra);
                emprestimo = emprestimoDAO.readById(idEmprestimo);
                emprestimo.setIdUsuario(usuario);
                emprestimo.setIdObra(obra);
                emprestimo.setDataemprestimo(new Date());
                
                request.getSession().setAttribute("emprestimos", emprestimoDAO.read());
                break;
                
            case "inserir":
                request.getSession().setAttribute("emprestimos", emprestimoDAO.read());
                request.getSession().setAttribute("obras", obraDAO.read());
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
                
                returnPage = "WEB-INF/jsp/emprestimo/inserir.jsp";
                break;
                
            case "inserir.confirmar":
                idObra = Long.parseLong(request.getParameter("obras"));
                idUsuario = Long.parseLong(request.getParameter("usuarios"));
                
                obra = obraDAO.readById(idObra);
                usuario = usuarioDAO.readById(idUsuario);
                emprestimo = new Emprestimo();
                emprestimo.setIdObra(obra);
                emprestimo.setIdUsuario(usuario);
                emprestimo.setDataemprestimo(new Date());
                emprestimoDAO.persist(emprestimo);
                
                request.getSession().setAttribute("emprestimos", emprestimoDAO.read());
                break;
                
            case "remover":
                request.getSession().setAttribute("emprestimos", emprestimoDAO.read());
                
                returnPage = "WEB-INF/jsp/emprestimo/remover.jsp";
                break;
                
            case "remover.confirmar":
                idEmprestimo = Long.parseLong(request.getParameter("emprestimos"));
                
                emprestimo = emprestimoDAO.readById(idEmprestimo);
                emprestimoDAO.remove(emprestimo);
                
                request.getSession().setAttribute("emprestimos", emprestimoDAO.read());
                break;
                
            case "visualizar":
                request.getSession().setAttribute("emprestimos", emprestimoDAO.read());
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

    private ObraDAO lookupObraDAOBean() {
        try {
            Context c = new InitialContext();
            return (ObraDAO) c.lookup("java:global/ProjetoColecionador/ProjetoColecionador-ejb/ObraDAO!com.br.lp3.model.dao.ObraDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UsuarioDAO lookupUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (UsuarioDAO) c.lookup("java:global/ProjetoColecionador/ProjetoColecionador-ejb/UsuarioDAO!com.br.lp3.model.dao.UsuarioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EmprestimoDAO lookupEmprestimoDAOBean() {
        try {
            Context c = new InitialContext();
            return (EmprestimoDAO) c.lookup("java:global/ProjetoColecionador/ProjetoColecionador-ejb/EmprestimoDAO!com.br.lp3.model.dao.EmprestimoDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
