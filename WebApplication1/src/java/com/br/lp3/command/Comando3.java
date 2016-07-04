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
public class Comando3 implements Command{

    private HttpServletRequest request;

    @Override
    public void execulte() {
        request.getSession().setAttribute("teste", "3");
    }

    @Override
    public void init(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getReturnPage() {
        return "pagina3.jsp";
    }
    
}
