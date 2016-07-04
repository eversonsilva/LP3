/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import com.br.lp3.ejb.CalcEJBInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
public class CalcCommand implements Command{
    CalcEJBInterface calculadora = lookupCalcEJBLocal();

    private HttpServletRequest request;
    private HttpServletResponse response;
  
//    @EJB
//    private CalcEJBInterface calculadora;
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        Double n1 = Double.parseDouble(request.getParameter("n1"));
        Double n2 = Double.parseDouble(request.getParameter("n2"));
        String op = request.getParameter("op");
        double resultado = 0;
        
        switch(op){
            case "+":
                resultado = calculadora.soma(n1, n2);
                break;
                
            case "-":
                resultado = calculadora.subtração(n1, n2);
                break;
            
            case "*":
                resultado = calculadora.multiplicação(n1, n2);
                break;
                
            case "/":
                resultado = calculadora.divisão(n1, n2);
                break;    
        }
        request.getSession().setAttribute("resultado", resultado);
    }

    @Override
    public String getReturnPage() {
        return "index.jsp";
    }

    private CalcEJBInterface lookupCalcEJBLocal() {
        try {
            Context c = new InitialContext();
            return (CalcEJBInterface) c.lookup("java:global/CalculadoraLp3/CalculadoraLp3-ejb/CalcEJB!com.br.lp3.ejb.CalcEJBInterface");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
