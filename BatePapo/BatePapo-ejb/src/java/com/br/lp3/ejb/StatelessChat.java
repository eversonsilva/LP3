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
@Stateless(mappedName = "Chat")
public class StatelessChat implements StatelessChatInterface {
    
    private String name = "Anonymous";

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void connect() {
        System.out.println(name+ " Entrou na sala");
    }

    @Override
    public void disconnect() {
        System.out.println(name+ " Saiu da Sala");
    }

    @Override
    public void say(String msg) {
        System.out.println(name+ " falou: " +msg);
    }
    
}
