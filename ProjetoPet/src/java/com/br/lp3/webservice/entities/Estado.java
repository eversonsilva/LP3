/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.webservice.entities;

import java.io.Serializable;

/**
 *
 * @author Everson
 */
public class Estado implements Serializable{
    
    private String name, initials;

    public Estado(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public String toString() {
        return "Estado{" + "name=" + name + ", initials=" + initials + '}';
    }
    
    
    
}
