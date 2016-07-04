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
    
    public double soma(double num1, double num2);
    public double subtração(double num1, double num2);
    public double multiplicação(double num1, double num2);
    public double divisão(double num1, double num2);

}
