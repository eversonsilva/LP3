/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Everson
 */
public interface Mensagem extends Remote{
    
    public void diz(String name, String msg) throws RemoteException;
    public List<String> getMsg() throws RemoteException;
}
