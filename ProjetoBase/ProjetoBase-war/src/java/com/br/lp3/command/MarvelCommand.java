package com.br.lp3.command;

import com.br.lp3.marvel.MarvelCharacter;
import com.br.lp3.marvel.MarvelManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author 1147106
 */
public class MarvelCommand implements Command {
    MarvelManager marvelManager = lookupMarvelManagerBean();

    private String returnPage = "login.jsp";
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("action");
        switch (action) {
            case "buscar":
                String name = request.getParameter("name");
                List<MarvelCharacter> heroes = marvelManager.searchCharacter(name);
                request.getSession().setAttribute("heroes", heroes);
                returnPage = "pagina1.jsp";
                break;
        }

    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    private MarvelManager lookupMarvelManagerBean() {
        try {
            Context c = new InitialContext();
            return (MarvelManager) c.lookup("java:global/ProjetoBase/ProjetoBase-ejb/MarvelManager!com.br.lp3.marvel.MarvelManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
