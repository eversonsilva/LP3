/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.taglib;

import com.br.lp3.webservice.entities.Pet;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Everson
 */
public class PetTag extends SimpleTagSupport{

    private Pet pet;
    
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println("<article class='pet'>");
                out.println("<img src='"+pet.getPhoto()+"' alt='imagem do pet'>");
                out.println("<div>");
                out.println("<h1>"+pet.getName()+" <small>("+pet.getRace()+")</small></h1>");
                out.println("<p>"+pet.getDescription()+"</p>");
                out.println("<p>"+pet.getAge()+"</p>");
                out.println("<p>"+pet.getCity()+" - "+pet.getState().getInitials()+" - "+pet.getCountry().getName()+"</p>");
                out.println("</div>");
                out.println("</article>");
        
    }

    
    
    
}
