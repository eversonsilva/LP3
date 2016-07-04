/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Everson
 */
public class MensagemImpl extends UnicastRemoteObject implements Mensagem{

    private List<String> mensagens;
    
    public MensagemImpl() throws RemoteException{
        mensagens = new ArrayList<>();
    }

    @Override
    public void diz(String name, String msg) throws RemoteException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String msg2 = formatter.format(new Date()) + " " + name + " disse:" + msg;
        System.out.println(msg2);
        mensagens.add(msg2);
    }

    @Override
    public List<String> getMsg() throws RemoteException {
        return mensagens;
    }

    
    
}
