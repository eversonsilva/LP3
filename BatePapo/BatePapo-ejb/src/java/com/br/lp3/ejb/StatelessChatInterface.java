/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Everson
 */
@Remote
public interface StatelessChatInterface {

    void disconnect();

    void connect();

    void say(String msg);
    
}
