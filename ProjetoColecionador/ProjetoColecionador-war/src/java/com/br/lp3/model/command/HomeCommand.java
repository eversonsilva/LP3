package com.br.lp3.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
public class HomeCommand implements Command {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private final String returnPage = "home.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

}
