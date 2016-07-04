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
public interface Command {
    public void execute();
    public void init (HttpServletRequest request);
    public String getReturnPage();
    
}
