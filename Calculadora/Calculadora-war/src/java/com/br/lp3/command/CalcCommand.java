/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.command;

import com.br.lp3.ejb.CalcEJBInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
public class CalcCommand implements Command {

    CalcEJBInterface calculadora = lookupCalcEJBLocal();

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
    
    @Override
    public void execute() {
        String action =  request.getParameter("action") != null ? request.getParameter("action"):"";
        String visor = (String)request.getSession().getAttribute("visor") != null ? (String)request.getSession().getAttribute("visor"):"";
        
        System.out.println(action);
        System.out.println(visor);
        
        if(action.equals("C")){
            visor = "";
        }else if(action.equals("=")){
            double n1 = 0;
            double n2 = 0;
            n1 = Double.parseDouble(visor.split("\\+|\\-|\\*|\\/")[0]);
            n2 = Double.parseDouble(visor.split("\\+|\\-|\\*|\\/")[1]);
            double resultado = 0;
            if(visor.contains("+")){
                resultado = calculadora.soma(n1, n2);
            }else if(visor.contains("-")){
                resultado = calculadora.subtração(n1, n2);
            } else if(visor.contains("*")){
                resultado = calculadora.multiplicação(n1, n2);
            } else if(visor.contains("/")){
                resultado = calculadora.divisão(n1, n2);
            }
            visor = resultado+"";
        }else{
            visor = visor.concat(action);
        }
        request.getSession().setAttribute("visor", visor);
    }

//    @Override
//    public void execute() {
//
//        String action = request.getParameter("action");
//        String equacao = (String) request.getSession().getAttribute("equacao");
//
//        double n1 = 0;
//        double n2 = 0;
//        double resultado = 0;
//
//        System.out.println(action);
//        System.out.println(equacao);
//        System.out.println(n1);
//        System.out.println(n2);
//
//        switch (action) {
//            case "C":
//                request.getSession().setAttribute("equacao", "");
//                break;
//            case "=":
//                n1 = Double.parseDouble("equacao".split("\\+|\\-|\\*|\\/")[0]);
//                n2 = Double.parseDouble("equacao".split("\\+|\\-|\\*|\\/")[1]);
//
//            case "+":
//                resultado = calculadora.soma(n1, n2);
//                break;
//            case "-":
//                resultado = calculadora.subtração(n1, n2);
//                break;
//            case "/":
//                resultado = calculadora.divisão(n1, n2);
//                break;
//            case "*":
//                resultado = calculadora.multiplicação(n1, n2);
//                break;
//            default:
//                request.getSession().setAttribute("equacao", equacao.concat(action));
//                break;
//        }
//    }

    @Override
    public String getReturnPage() {
        return "index.jsp";
    }

    private CalcEJBInterface lookupCalcEJBLocal() {
        try {
            Context c = new InitialContext();
            return (CalcEJBInterface) c.lookup("java:global/Calculadora/Calculadora-ejb/CalcEJB!com.br.lp3.ejb.CalcEJBInterface");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

//                ScriptEngineManager mgr = new ScriptEngineManager();
//                ScriptEngine engine = mgr.getEngineByName("JavaScript");
//                equacao = equacao.replace("mais", "+");
//                 {
//                    try {
//                        request.getSession().setAttribute("equacao", engine.eval(equacao));
//                    } catch (ScriptException ex) {
//                        Logger.getLogger(CalcCommand.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
