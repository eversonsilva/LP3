/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.command;

import com.br.lp3.model.dao.TipoUsuarioDAO;
import com.br.lp3.model.dao.UsuarioDAO;
import com.br.lp3.model.entities.Tipousuario;
import com.br.lp3.model.entities.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
public class LoginCommand implements Command {
    TipoUsuarioDAO tipoUsuarioDAO = lookupTipoUsuarioDAOBean();
    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String returnPage = "index.jsp";
    private Usuario usuario;

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
        usuarioDAO.setEm(em);
        tipoUsuarioDAO.setEm(em);
        em.getTransaction().begin();
        
        String action = request.getParameter("action");
        request.getSession().setAttribute("tipoUsuarios", tipoUsuarioDAO.read());
        
        switch (action) {
            case "cadastrar":
                returnPage = "registro.jsp";
                break;

            case "registro":

                String fullname = request.getParameter("fullname");
                String username1 = request.getParameter("username");
                String pwd1 = request.getParameter("pwd1");
                String pwd2 = request.getParameter("pwd2");
                Long tipoUsuario = Long.parseLong(request.getParameter("tipoUsuario"));
                
                if (pwd1.equals(pwd2)) {
                    Usuario user = new Usuario();
                    user.setNomeusuario(fullname);
                    user.setUserusuario(username1);
                    user.setSenhausuario(pwd1);
                    
                    Tipousuario tu = tipoUsuarioDAO.readById(tipoUsuario);
                    user.setIdTipousuario(tu);
            
                    usuarioDAO.persist(user);
                    returnPage = "home.jsp";
                }else{
                    request.getSession().setAttribute("errormsg", "As senhas não conferem");
                    returnPage = "registro.jsp";
                }
                break;

            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                if (acesso(username, password)) {

                    String check = request.getParameter("lembrar");
                    if ("on".equals(check)) {
                        Cookie cookie = new Cookie("username", username);
                        cookie.setMaxAge(60 * 60 * 24);
                        response.addCookie(cookie);

                        Cookie cookie2 = new Cookie("password", password);
                        cookie2.setMaxAge(60 * 60 * 24);
                        response.addCookie(cookie2);
                    } else {
                        Cookie[] cookies = request.getCookies();
                        for (Cookie cookie : cookies) {
                            if ("username".equals(cookie.getName()) || "password".equals(cookie.getName())) {
                                cookie.setValue("");
                                cookie.setMaxAge(-1);
                                response.addCookie(cookie);
                            }
                        }
                    }
                    returnPage = "home.jsp";
                } else {
                    request.getSession().setAttribute("errormsg", "Usuário inexistente ou senha não confere");
                    returnPage = "index.jsp";
                }

                break;
            case "logout":
                request.getSession().setAttribute("user", null);
                returnPage = "index.jsp";
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
    
    public boolean acesso(String username, String senha){
        return (usuario=usuarioDAO.readByNameAndPassword(username, senha)) != null;
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

    private TipoUsuarioDAO lookupTipoUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (TipoUsuarioDAO) c.lookup("java:global/ProjetoColecionador/ProjetoColecionador-ejb/TipoUsuarioDAO!com.br.lp3.model.dao.TipoUsuarioDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
