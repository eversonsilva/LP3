package com.br.lp3.command;

import com.br.lp3.exceptions.DBException;
import com.br.lp3.model.dao.GenericDAO;
import com.br.lp3.model.dao.MarvelUserDAO;
import com.br.lp3.model.entities.Marveluser;
import com.br.lp3.model.entities.Userinfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
public class UserCommand implements Command {
    MarvelUserDAO marvelUserDAO = lookupMarvelUserDAOLocal();

    
    

    public HttpServletRequest request;
    public HttpServletResponse response;
    public String returnPage = "index.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        switch (action) {
            case "register":

                String fullname = request.getParameter("fullname");
                String username1 = request.getParameter("username");
                String pwd1 = request.getParameter("pwd1");
                String pwd2 = request.getParameter("pwd2");
                String datestr = request.getParameter("bday");
                String email = request.getParameter("email");

                try {
                    marvelUserDAO.findByName(username1);
                    request.getSession().setAttribute("errormsg", "Usuário já existe!");
                    returnPage = "login.jsp";
                } catch (Exception ex1) {

                    if (pwd1.equals(pwd2)) {

                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date();
                        try {
                            date = formatter.parse(datestr);
                        } catch (ParseException ex) {
                            Logger.getLogger(UserCommand.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        Userinfo userinfo = new Userinfo();
                        userinfo.setEmail(email);
                        userinfo.setFullname(fullname);
                        userinfo.setBday(date);

                        Marveluser mu = new Marveluser();
                        mu.setPassword(pwd1);
                        mu.setUsername(username1);
                        mu.setUserinfo(userinfo);
                        
                        userinfo.setMarveluser(mu);
                        try {
                            marvelUserDAO.persist(mu);
                        } catch (DBException ex) {
                            request.getSession().setAttribute("errormsg", "Erro na conexão com o banco. Tente novamente!");
                            returnPage = "login.jsp";
                        }
                    } else {
                        request.getSession().setAttribute("errormsg", "Senhas não conferem!");
                        returnPage = "login.jsp";
                    }
                }
                break;

            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                Marveluser user = null;
                try {
                    user = marvelUserDAO.findByName(username);

                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

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

                        returnPage = "pagina1.jsp";
                        request.getSession().setAttribute("user", username);
                    } else {
                        request.getSession().setAttribute("errormsg", "Usuário inexistente ou senha não confere");
                        returnPage = "login.jsp";
                    }
                } catch (Exception ex1) {
                    request.getSession().setAttribute("errormsg", "Usuário não encontrado");
                    returnPage = "login.jsp";
                }

                break;
            case "logout":
                request.getSession().setAttribute("user", null);
                returnPage = "index.jsp";
                break;
        }

    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private MarvelUserDAO lookupMarvelUserDAOLocal() {
        try {
            Context c = new InitialContext();
            return (MarvelUserDAO) c.lookup("java:global/ProjetoBase/ProjetoBase-ejb/MarvelUserDAO!com.br.lp3.model.dao.MarvelUserDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    

    

}
