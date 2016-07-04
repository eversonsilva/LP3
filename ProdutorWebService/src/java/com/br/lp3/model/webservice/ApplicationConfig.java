/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.webservice;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Everson
 */

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(com.br.lp3.model.webservice.Servico.class);
        return super.getClasses();
    }
    
}
