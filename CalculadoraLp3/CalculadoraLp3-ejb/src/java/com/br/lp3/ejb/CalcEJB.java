/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Everson
 */
@Stateless
public class CalcEJB implements CalcEJBInterface {

    @Override
    public double soma(double a, double b) {
        return (a+b);
    }

    @Override
    public double subtração(double a, double b) {
        return (a-b);
    }

    @Override
    public double multiplicação(double a, double b) {
        return (a*b);
    }

    @Override
    public double divisão(double a, double b) {
        return (a/b);
    }

    
    
}
