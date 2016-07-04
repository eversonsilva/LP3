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
    public double soma(double num1, double num2) {
        return (num1 + num2);
    }

    @Override
    public double subtração(double num1, double num2) {
        return (num1 - num2);
    }

    @Override
    public double multiplicação(double num1, double num2) {
        return (num1 * num2);
    }

    @Override
    public double divisão(double num1, double num2) {
        return (num1 / num2);
    }

}
