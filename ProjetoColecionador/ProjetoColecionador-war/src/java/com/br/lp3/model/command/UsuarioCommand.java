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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */

public class UsuarioCommand implements Command {
    UsuarioDAO usuarioDAO = lookupUsuarioDAOBean();
    TipoUsuarioDAO tipoUsuarioDAO = lookupTipoUsuarioDAOBean();
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String returnPage = "WEB-INF/jsp/usuario/visualizar.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("colecionador_pu");
        EntityManager em = emf.createEntityManager();
        usuarioDAO.setEm(em);
        tipoUsuarioDAO.setEm(em);
        em.getTransaction().begin();
        
        String action = request.getParameter("action");
        String nomeUsuario;
        String userUsuario;
        String senhaUsuario;
        Tipousuario tipoUsuario;
        Long idUsuario;
        Long idTipoUsuario;
        Usuario usuario;
        switch(action){
            
            case "alterar":
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
                request.getSession().setAttribute("tipoUsuarios", tipoUsuarioDAO.read());
                
                returnPage = "WEB-INF/jsp/usuario/alterar.jsp";
                break;
                
            case "alterar.confirmar":
                
                idUsuario = Long.parseLong(request.getParameter("usuarios"));
                nomeUsuario = request.getParameter("nomeUsuario");
                userUsuario = request.getParameter("userUsuario");
                senhaUsuario = request.getParameter("senhaUsuario");
                idTipoUsuario = Long.parseLong(request.getParameter("tipousuarios"));
                
                /* PERSITE O OBJETO NO BANCO */
                tipoUsuario = tipoUsuarioDAO.readById(idTipoUsuario);
                usuario = usuarioDAO.readById(idUsuario);
                usuario.setNomeusuario(nomeUsuario);
                usuario.setUserusuario(userUsuario);
                usuario.setSenhausuario(senhaUsuario);
                usuario.setIdTipousuario(tipoUsuario);
                
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
                break;
                
            case "inserir":
                request.getSession().setAttribute("tipousuarios", tipoUsuarioDAO.read());
                
                returnPage = "WEB-INF/jsp/usuario/inserir.jsp";
                break;
                
            case "inserir.confirmar":

                nomeUsuario = request.getParameter("nomeUsuario");
                userUsuario = request.getParameter("userUsuario");
                senhaUsuario = request.getParameter("senhaUsuario");
                idTipoUsuario = Long.parseLong(request.getParameter("tipousuarios"));
                
                tipoUsuario = tipoUsuarioDAO.readById(idTipoUsuario);
                usuario = new Usuario();
                usuario.setNomeusuario(nomeUsuario);
                usuario.setUserusuario(userUsuario);
                usuario.setSenhausuario(senhaUsuario);
                usuario.setIdTipousuario(tipoUsuario);
                usuarioDAO.persist(usuario);
                
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
                break;
                
            case "remover":
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
                
                returnPage = "WEB-INF/jsp/usuario/remover.jsp";
                break;
                
            case "remover.confirmar":
                idUsuario = Long.parseLong(request.getParameter("usuarios"));
                
                usuario = usuarioDAO.readById(idUsuario);
                usuarioDAO.remove(usuario);
                
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
                break;
                
            case "visualizar":
                request.getSession().setAttribute("usuarios", usuarioDAO.read());
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

    private TipoUsuarioDAO lookupTipoUsuarioDAOBean() {
        try {
            Context c = new InitialContext();
            return (TipoUsuarioDAO) c.lookup("java:global/ProjetoColecionador/ProjetoColecionador-ejb/TipoUsuarioDAO!com.br.lp3.model.dao.TipoUsuarioDAO");
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

}
