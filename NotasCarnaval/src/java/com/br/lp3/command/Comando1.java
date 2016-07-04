/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Everson
 */
public class Comando1 implements Command {

    private HttpServletRequest request;

    @Override
    public void execute() {

        String jurados = request.getParameter("jurados");
        String escolas = request.getParameter("escolas");
        request.getSession().setAttribute("jurados", jurados);
        request.getSession().setAttribute("escolas", escolas);
    }

    @Override
    public void init(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getReturnPage() {
        return "pagina1.jsp";
    }

}
