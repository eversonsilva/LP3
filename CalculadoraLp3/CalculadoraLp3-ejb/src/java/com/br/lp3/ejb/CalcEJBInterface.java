/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.ejb;

import javax.ejb.Local;

/**
 *
 * @author Everson
 */
@Local
public interface CalcEJBInterface {
    
    public double soma(double a, double b);
    public double subtração(double a, double b);
    public double multiplicação(double a, double b);
    public double divisão(double a, double b);
    
}
