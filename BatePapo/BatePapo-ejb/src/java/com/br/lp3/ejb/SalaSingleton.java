/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Everson
 */
@Singleton //Unico uma instancia para todos os cleintes
@LocalBean // Não possuir interface local
@WebListener //Ouvinte da Sessão
@Startup //Inicializa junto com a subido do servidor 
public class SalaSingleton implements HttpSessionListener  {

    private int cont = 0;
    
    //Chamando logo após a contrução
    @PostConstruct
    private void init(){
        System.out.println("Sala criada");
    }
    
    //Chamado logo antes da destruição
    @PreDestroy
    private void close(){
        System.out.println("Sala Fechada");
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        cont++;
        System.out.println("Usuários Ativos" +cont);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        cont--;
        System.out.println("Usuários Ativos " +cont);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
