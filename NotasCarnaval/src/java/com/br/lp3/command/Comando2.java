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
public class Comando2 implements Command{

    private HttpServletRequest request;

    @Override
    public void execute() {

        request.getSession().setAttribute("jurados", request.getParameter("escolas"));
        request.getSession().setAttribute("escolas", request.getParameter("jurados"));
        
        Double notas[][] = new Double[Integer.parseInt(request.getParameter("escolas"))][Integer.parseInt(request.getParameter("jurados"))];

                for(Integer linha = 0; linha <= notas.length-1 ; linha++){
                    for(Integer coluna = 0; coluna <= notas[notas.length-1].length-1 ; coluna++){
                        notas[linha][coluna] = Double.parseDouble(request.getParameter("nota"+(linha+1)+"x"+(coluna+1)));
                        System.out.println(notas[linha][coluna]);
                    }
                }
                request.getSession().setAttribute("notas", notas);
    }

    @Override
    public void init(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getReturnPage() {
        return "pagina2.jsp";
    }
    
}
